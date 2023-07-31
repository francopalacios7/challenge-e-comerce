const { createApp } = Vue;

createApp({
  data() {
    return {
      //Propiedades Reactivas
      model: "",
      date: null,
<<<<<<< HEAD
      allColors: ["BLACK", "WHITE", "BLUE"],
=======
      allColors: [],
>>>>>>> cd42151eef4bf8910bbfca607ce7bcadf4247b05
      color: null,
      price: 0,
      paymentsInput: '',
      payments: [],
      stock: 0,
      images: ["", "", ""],
      packM: false,
<<<<<<< HEAD
      allMods: ["SPOILER", "ALLOY_WHEELS", "TINTED_WINDOWS", "NAVIGATION_SYSTEM", "SUNROOF", "PERFORMANCE_EXHAUST", "OTHER"],
=======
      allMods: [],
>>>>>>> cd42151eef4bf8910bbfca607ce7bcadf4247b05
      carMod: []

    }
  },

  created() {
<<<<<<< HEAD

=======
    this.getCarColors()
    this.getAllMods()
>>>>>>> cd42151eef4bf8910bbfca607ce7bcadf4247b05
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
<<<<<<< HEAD
=======
    getCarColors(){
      axios.get('/api/car/color')
      .then(response => {
       // console.log(response.data);
        this.allColors = response.data
        console.log(this.allColors);
      })
      .catch(error => {
        console.log(error);
      })
    },
    getAllMods(){
      axios.get('/api/mods')
      .then(response => {
        console.log(response.data);
        this.allMods = response.data
        
      })
      .catch(error => {
        console.log(error);
      })
    },
>>>>>>> cd42151eef4bf8910bbfca607ce7bcadf4247b05
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