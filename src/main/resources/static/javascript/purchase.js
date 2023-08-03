const { createApp } = Vue;

createApp({
  data() {
    return {
      loading: true,
      cars: [],
      filteredCars: [],
      selectedType: [],
      selectedColors: [],
      inputPriceFilter: "",
      selectedYear: null,
      packM: false,
      icons: [
        "bi bi-car-front-fill",
        "bi bi-fuel-pump",
        "bi bi-speedometer2",
        "bi bi-lightning-charge-fill",
      ],
    };
  },
  mounted() {
    // Simula un tiempo de carga, luego oculta el loader
    setTimeout(() => {
      this.loading = false;
    }, 2000); // Cambia el valor según tus necesidades
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
        (this.selectedType.length === 0 ||
          this.selectedType.includes(car.carType)) &&
        (this.selectedColors.length === 0 ||
          this.selectedColors.includes(car.carColor)) &&
        (!this.packM || car.packM === this.packM) &&
        (!this.selectedYear || parseInt(car.date) === this.selectedYear)
      ) {
        this.filteredCars = this.cars;
      } else {
        this.filteredCars = this.cars.filter((car) => {
          console.log(typeof car.date);
          console.log(typeof this.selectedYear);
          let passesTypeFilter =
            this.selectedType.length === 0 ||
            this.selectedType.includes(car.carType);
          let passesColorFilter =
            this.selectedColors.length === 0 ||
            this.selectedColors.includes(car.carColor);
          let passesYearFilter =
            !this.selectedYear || parseInt(car.date) === this.selectedYear;
          let passesPackMFilter = !this.packM || car.packM === this.packM;

          return (
            passesTypeFilter &&
            passesColorFilter &&
            passesYearFilter &&
            passesPackMFilter
          );
        });
      }
      console.log("Filtered Cars:", this.filteredCars);
    },

    getIcon(item) {
      if (this.icons[item]) {
        return this.icons[item];
      } else {
        return "bi bi-car-front-fill";
      }
    },
  },
  watch: {
    selectedType: "applyFilters",
    selectedColors: "applyFilters",
    packM: "applyFilters",
    selectedYear: "applyFilters",
  },
}).mount("#app");
