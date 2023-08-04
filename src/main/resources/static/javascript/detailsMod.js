const { createApp } = Vue;

createApp({
  data() {
    return {
      mods:[],
      showConfirmation: false,
      err: '',
      modImages:[],
      params: '',
      selectedImg: "",
      /* icons: [
        "bi bi-car-front-fill",
         "bi bi-fuel-pump",
         "bi bi-speedometer2",
         "bi bi-lightning-charge-fill"
      ] */
    }
  },

  created(){
    this.getCars();
  /*   this.loadData(); */

    this.params = new URLSearchParams(location.search).get("id");
    console.log("ID from URL:", this.params);
  },
  methods: {
    getCars(){
        axios.get("/api/mods")
        .then(response => {
            
          this.mods = response.data.filter(mod => mod.id == this.params);
          console.log("this mods:  ", this.mods);
          this.modImages = this.mods[0].images /* .slice(1, this.cars[0].images.length); */
          console.log("filtered Images:",this.modImages );
        }).catch(err => console.error(err))
    },
    chooseImg(img){
      console.log(img)
      this.selectedImg = img
    },
    /* loadData(){
      axios.get('/api/clients/current')
      .then(res => {
        console.log(res.data);
      });
    }, */
    cancelRegister() {
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
    },
    getIcon(item) {
      console.log("item = " + item)
      if (this.icons[item]) {
        return this.icons[item];
      } else {
        return "bi bi-car-front-fill"
      }
    },
  }
}).mount('#app');