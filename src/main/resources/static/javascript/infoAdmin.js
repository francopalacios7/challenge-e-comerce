const { createApp } = Vue;

createApp({
  data() {
    return {
      cars:[],
      err: '',
      carImages:[],
      input: "",
      inputMods:"",
      carsFiltrados:[],
/*       params: '' */

      itemsPerPage: 5,
      currentPage: 1,
      itemsPerPageMods: 5,
      currentPageMods: 1,
      mods:[],
      modsFiltrados:[]
    }
  },

  created(){
    axios.get("/api/car")
        .then(response => {
                  
          this.cars = response.data;
          this.paginateCars();
          this.carsFiltrados = this.cars.filter(car => car.active == true)/* this.cars.slice(0, this.itemsPerPage) */
          console.log("Cars:", this.cars);
          console.log("Cars Filtrados:", this.carsFiltrados);

        }).catch(error => {
          console.error(error);
          this.err = error.response.data;
          console.log(this.err)
          this.showNotification(this.err, 'error');
        });


        axios.get("/api/mods")
        .then(response => {
          console.log(response);
          this.mods = response.data;
          console.log(this.mods);
          this.modsFiltrados = this.mods.map(mod => mod.name)
          console.log(this.modsFiltrados);
            //this.modsFiltrados = this.mods.slice(0, this.itemsPerPageMods); // Set to first 5 elements initially
            console.log("Mods:", this.mods);
            console.log("Mods Filtrados:", this.modsFiltrados);  
            // ...
        }).catch(error => {
          console.error(error);
          this.err = error.response.data;
          console.log(this.err)
          this.showNotification(this.err, 'error');
        });
/* 
    this.params = new URLSearchParams(location.search).get("id");
    console.log("ID from URL:", this.params); */
  },

  computed: {
    filtro: function() {
      return this.cars.filter((car) => car.model.toLowerCase().includes(this.input.toLowerCase()));
    },

    filtroMods: function() {
      return this.mods.filter((mod) => mod.name.toLowerCase().includes(this.inputMods.toLowerCase()));
    }
  },

  watch: {
    input: function(newValue, oldValue) {
      this.carsFiltrados = this.filtro;
    },

    inputMods: function(newValue, oldValue){
      this.modsFiltrados = this.filtroMods;
    }
  },

  methods: {

    paginateMods() {
      const startIndex = (this.currentPageMods - 1) * this.itemsPerPageMods;
      const endIndex = startIndex + this.itemsPerPageMods;
      this.modsFiltrados = this.mods.slice(startIndex, endIndex);
    },

    changePageMods(page) {
      if (page < 1 || page > Math.ceil(this.mods.length / this.itemsPerPageMods)) {
        return;
      }
      this.currentPageMods = page;
      this.paginateMods();
    },


    paginateCars() {
      const startIndex = (this.currentPage - 1) * this.itemsPerPage;
      const endIndex = startIndex + this.itemsPerPage;
      this.carsFiltrados = this.cars.slice(startIndex, endIndex);
    },
  
    changePage(page) {
      if (page < 1 || page > Math.ceil(this.cars.length / this.itemsPerPage)) {
        return;
      }
      this.currentPage = page;
      this.paginateCars();
    },

    deleteCar(id){
      axios.patch(`/api/admin/car/delete/${id}`)
      .then(response => {
        console.log("car deleted!!");
        window.location.reload();
      })
      .catch(error => {
        console.log(error);
      })
    }

  }
}).mount('#app');