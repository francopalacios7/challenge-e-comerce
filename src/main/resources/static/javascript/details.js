const { createApp } = Vue;

createApp({
  data() {
    return {
      cars:[],
      showConfirmation: false,
      err: '',
      carImages:[],
      params: '',
      selectedImg: "",
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
        axios.get("/api/car")
        .then(response => {
                  
          this.cars = response.data.filter(car => car.model === this.params);
          console.log("this cars: ", this.cars);
          this.carImages = this.cars[0].images;
          console.log("filtered Images:",this.carImages );
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
    }
  }
}).mount('#app');