const { createApp } = Vue;

createApp({
  data() {
    return {
      promotions: [],
      showConfirmation: false,
      err: "",
      params: "",
      icons: [
        "bi bi-cup-hot",
        "bi bi-capslock",
        "bi-rocket",
      ],
    };
  },

  created() {
    this.getPromotions();
    this.params = parseFloat(new URLSearchParams(location.search).get("price"));
    console.log("ID from URL:", this.params);
  },
  methods: {
    getPromotions() {
      axios
        .get("/api/duesPlan")
        .then((response) => {
          this.promotions = response.data;
          console.log("this promotions: ", this.promotions);
        })
        .catch((err) => console.error(err));
    },
    showNotification(message, type) {
      const toast = document.createElement("div");
      toast.classList.add("toastify", type);
      toast.textContent = message;
      document.body.appendChild(toast);

      setTimeout(() => {
        toast.classList.add("show");
        setTimeout(() => {
          toast.classList.remove("show");
          setTimeout(() => {
            document.body.removeChild(toast);
          }, 300);
        }, 2000);
      }, 100);
    },
    getIcons(item) {
      console.log("item = " + item);
      if (this.icons[item]) {
        return this.icons[item];
      } else {
        return "bi bi-car-front-fill"; 
      }
    },
    formatCurrency(currency) {
      const format = new Intl.NumberFormat("en-US", {
        style: "currency",
        currency: "USD",
      });

      return format.format(currency);
    },
    getItereset(interest) {
      return this.params * interest + this.params;
    },
  },
}).mount("#app");
