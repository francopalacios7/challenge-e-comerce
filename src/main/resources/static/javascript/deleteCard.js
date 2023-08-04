const { createApp } = Vue;

createApp({
  data() {
    return {
      cars:[],
      carToUpdate:[],
      showConfirmation: false,
      err: '',
      carImages:[],
      params: '',
      /* Update */
      model: "",
      date: null,
/*       allTypes:[ CAR,SUV, MOTORCYCLE], */
      type:null,
      allColors: ["BLACK", "WHITE", "BLUE"],
      color: null,
      price: 0,
      paymentsInput: '',
      payments: [],
      stock: 0,
      images: ["", "", ""],
      packM: false,
      allMods: ["SPOILER", "ALLOY_WHEELS", "TINTED_WINDOWS", "NAVIGATION_SYSTEM", "SUNROOF", "PERFORMANCE_EXHAUST", "OTHER"],
      carMod: []
    }
  },

  created(){
    this.loadData();
    this.params = new URLSearchParams(location.search).get("id");
    console.log("ID from URL:", this.params);

    axios.get("/api/car")
    .then(response => {

      this.cars = response.data;
      this.carToUpdate = this.cars.filter((car) => car.id == this.params);

      console.log("Cars:",this.cars );
      console.log("Car to Update", this.carToUpdate)
    }).catch(error => {
        console.error(error);
        this.err = error.response.data;
        console.log(this.err)
        this.showNotification(this.err, 'error');

      });

  },
  methods: {

    loadData(){
      axios.get('/api/clients/current')
      .then(res => {
        console.log(res.data);
      });
    },


    update() {
      this.showConfirmation = true
    },

    confirmUpdate() {
      this.showConfirmation = false;

    axios.patch('/api/admin/car/delete',  `id=${this.params}`)
        .then((res) => {
          if (res.status === 200) {
            this.showNotification('Car Updated', 'success');
            setTimeout(() => {
              window.location.href = './infoAdmin.html';
            }, 700);
          }
        })
      .catch(error => {
        console.error(error);
        this.err = error.response.data;
        console.log(this.err)
          this.showNotification(this.err, 'error');

      });
    },


    cancelUpdate() {
      this.showConfirmation = false;
    },

    showNotification(message, type) {
      const toast = document.createElement('div');
      toast.classList.add('toastify', type);
      toast.textContent = message;
      document.body.appendChild(toast);

      setTimeout(() => {
        toast.classList.add('show');
        setTimeout(() => {
          toast.classList.remove('show');
          setTimeout(() => {
            document.body.removeChild(toast);
          }, 300);
        }, 2000);
      }, 100);
    }
  }
}).mount('#app');