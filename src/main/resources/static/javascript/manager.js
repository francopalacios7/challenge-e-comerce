const { createApp } = Vue;

createApp({
  data() {
    return {
      //Propiedades Reactivas
      model: "",
      date: null,
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

  created() {

  },
  methods: {
    updateCarModArray(event, mod) {
      if(event.target.checked) {
        // Si el checkbox está marcado, añade el mod al array
        this.carMod.push(mod);
      } else {
        // Si el checkbox no está marcado, remueve el mod del array
        const index = this.carMod.indexOf(mod);
        if (index !== -1) {
          this.carMod.splice(index, 1);
        }
      }
    },
    updateCarColorArray(event, color) {
      this.color = color;
    },
    getData(){
      axios.get('/rest/cars')
      .then(response => {
        console.log(response);
      })
      .catch(error =>{
        console.log(error);
      })
    },
    convertToNumbers() {
      this.payments = this.paymentsInput.split(',').map(Number);
    },
    addCar() {
      axios.post('/api/admin/cars', { 'model': this.model, 'date': this.date, 'carColor': this.color, 
      'price': this.price, 'payments': this.payments, 'packM': this.packM, 'stock': this.stock, 'images': this.images, 'modType': this.carMod })
        .then(response => {
          console.log("Car added!!");
       
        })
        .catch(
          error => {
            console.log(error);
            Swal.fire(
              'Oops..',
              `${error.response.data} Please try again.`,
              'error'
            )
          })
    }
  }
}).mount('#app');