const { createApp } = Vue;

createApp({
  data() {
    return {
      cars: [],
      filteredCars: [],
      selectedType: [],
      selectedColors: [],
      priceRange: [null, null],
      yearRange: [null, null],
      packM: false,
    };
  },
  created() {
    this.getCars();
  },
  methods: {
    getCars() {
      axios
        .get("/api/car")
        .then((response) => {
          console.log(response);
          this.cars = response.data.sort((a, b) => a.id - b.id);
          this.applyFilters();
          console.log("cars: " + this.cars);
        })
        .catch((err) => console.error(err));
    },
    updateColorFilter(color) {
      if (this.selectedColors.includes(color)) {
        this.selectedColors = this.selectedColors.filter((c) => c !== color);
      } else {
        this.selectedColors.push(color);
      }
      this.applyFilters();
    },
    applyFilters() {
      if (
        this.selectedType.length === 0 &&
        this.selectedColors.length === 0 &&
        (this.priceRange[0] === null || this.priceRange[1] === null) &&
        (this.yearRange[0] === null || this.yearRange[1] === null) &&
        !this.packM
      ) {
        this.filteredCars = this.cars;
      } else {
        this.filteredCars = this.cars.filter((car) => {
          let passesTypeFilter =
            this.selectedType.length === 0 || this.selectedType.includes(car.carType);
          let passesColorFilter =
            this.selectedColors.length === 0 || this.selectedColors.includes(car.carColor);
          let passesPriceFilter =
            !this.priceRange[0] ||
            !this.priceRange[1] ||
            (car.price >= this.priceRange[0] && car.price <= this.priceRange[1]);
          let passesYearFilter =
            !this.yearRange[0] ||
            !this.yearRange[1] ||
            (car.date >= this.yearRange[0] && car.date <= this.yearRange[1]);
          let passesPackMFilter = !this.packM || car.packM === this.packM;
    
          return (
            passesTypeFilter &&
            passesColorFilter &&
            passesPriceFilter &&
            passesYearFilter &&
            passesPackMFilter
          );
        });
      }
    
      console.log("Filtered Cars:", this.filteredCars);
    },
    

  },
  watch: {
    selectedType: "applyFilters",
    selectedColors: "applyFilters",
    priceRange: "applyFilters",
    yearRange: "applyFilters",
    packM: "applyFilters",
  },
}).mount("#app");
