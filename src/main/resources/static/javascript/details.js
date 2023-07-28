const { createApp } = Vue;

createApp({
  data() {
    return {
      cars:[],
      showConfirmation: false,
      err: '',
      carImages:[],
      params: ''
    }
  },

  created(){
    this.getCars();
    this.loadData();

    this.params = new URLSearchParams(location.search).get("id");
    console.log("ID from URL:", this.params);
  },
  methods: {
    getCars(){
        axios.get("/api/car")
        .then(response => {
                  
        const filteredCars = response.data.filter(car => car.model === this.params);
        console.log("filtered cars:", filteredCars);

        // Asignar el resultado al array de cars para mostrarlo en la interfaz
        this.cars = filteredCars;
        this.carImages = this.cars[0].images;
        console.log("filtered Images:",this.carImages );
        }).catch(err => console.error(err))
    },

    loadData(){
      axios.get('/api/clients/current')
      .then(res => {
        console.log(res.data);
      });
    },


    register() {
      this.showConfirmation = true
    },

    confirmRegister() {
      this.showConfirmation = false;
  
      axios.post('/api/clients', this.registerClient)
        .then((res) => {
          if (res.status === 201) {
            this.showNotification('Account Created', 'success');
            setTimeout(() => {
              window.location.href = './index.html';
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