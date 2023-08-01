const { createApp } = Vue;

createApp({
  data() {
    return {
      mods:[],
      modsToUpdate:[],
      showConfirmation: false,
      err: '',
      params: '',
      carColor:["BLACK","WHITE","BLUE"],
      modToSend:{
        name: '',
        description: '',
        carColor: '',
        price: null,
        stock: null
      }
      /* Update */
     
    }
  },

  created(){
    this.loadData();
    this.params = new URLSearchParams(location.search).get("id");
    console.log("ID from URL:", this.params);

    axios.get("/api/mods")
    .then(response => {

      this.mods = response.data;
      this.modsToUpdate = this.mods.filter((mod) => mod.id == this.params);

      console.log("Mods:",this.mods );
      console.log("Mod to Update", this.modsToUpdate)
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

      axios.patch('/api/admin/updateMods',  {'id': this.params, 'name': this.modToSend.name, 'description': this.modToSend.description, 
      'price': this.modToSend.price, 'carColor': this.modToSend.carColor, 'stock': this.modToSend.stock })
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