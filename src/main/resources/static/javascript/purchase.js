const { createApp } = Vue;

createApp({
  data() {
    return {
        cars: []
    }
  },
  created(){
    this.getCars()
  },
  methods: {
    getCars(){
        axios.get("/api/car")
        .then(response => {
            console.log(response)
            this.cars = response.data;
            console.log("cars: " + this.cars)
        }).catch(err => console.error(err))
    }
  }
}).mount('#app');