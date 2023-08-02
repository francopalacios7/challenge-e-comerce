const { createApp } = Vue;

createApp({
  data() {
    return {
      //Propiedades Reactivas
      model: "",
      date: null,
      allColors: [],
      color: null,
      price: 0,
      paymentsInput: '',
      payments: [],
      stock: 0,
      images: ["", "", ""],
      packM: false,
      allMods: [],
      carMod: [],
      modName: "",
      modDescription: "",
      modPrice: 0,
      modStock: 0,
      images2: ["", "", ""],
      modType: null,
      dueDescription: "",
      dues: "",
      dueInterest: 0,
      dueActive: false
    }
  },

  created() {
    this.getCarColors()
    this.getAllMods()
  },
  methods: {
    updateCarModArray(event, mod) {
      if (event.target.checked) {
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
    getData() {
      axios.get('/rest/cars')
        .then(response => {
          console.log(response);
        })
        .catch(error => {
          console.log(error);
        })
    },
    getCarColors() {
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
    getAllMods() {
      axios.get('/api/mods')
        .then(response => {
          console.log(response.data);
          //this.allMods = response.data
          this.allMods = response.data.map(mod => mod.name)
          console.log(this.allMods);

        })
        .catch(error => {
          console.log(error);
        })
    },
    convertToNumbers() {
      this.payments = this.paymentsInput.split(',').map(Number);
    },
    addCar() {
      axios.post('/api/admin/cars', {
        'model': this.model, 'date': this.date, 'carColor': this.color,
        'price': this.price, 'payments': this.payments, 'packM': this.packM, 'stock': this.stock, 'images': this.images, 'modType': this.carMod
      })
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
    },
    addMod() {
      axios.post('/api/admin/addMods', {
        'name': this.modName, 'description': this.modDescription, 'price': this.modPrice,
        'carColor': this.color, 'stock': this.modStock, 'images': this.images2, 'modType': this.modType
      })
        .then(response => {
          console.log("Mod added!!");

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
    },
    addDuesPlan() {
      axios.post('/api/admin/duesPlan', {
        'planDescription': this.dueDescription, 'dues': this.dues, 'interest': this.dueInterest,
        'isActive': this.dueActive
      })
        .then(response => {
          console.log("Dues plan added!!");

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