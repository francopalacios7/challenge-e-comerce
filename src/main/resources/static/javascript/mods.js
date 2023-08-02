const { createApp } = Vue;

createApp({
  data() {
    return {
      mods: [],
      arrayCarrito: [],
    };
  },
  created() {
    this.getMods();
  },
  methods: {
    getMods() {
      axios.get("/api/mods").then((response) => {
        this.mods = response.data.sort((a, b) => b.id - a.id);
        console.log("mods: ", this.mods);
        this.arrayCarrito = this.getLocalStorage() ?? [];

        console.log("ARRAY DEL CARRITO: ", this.arrayCarrito);
      });
    },
    añadirCarrito(id) {
      console.log(id);
      console.log(this.arrayCarrito.length);
      if (
        this.arrayCarrito.find(
          (articuloCarrito) => articuloCarrito.article.id == id
        )
      ) {
        return; /* alertify.success('Added to the cart'); */
      }

      const aux = this.mods.find((item) => item.id == id);
      console.log("aux ", aux);
      this.arrayCarrito.push({ article: aux, amount: 1 });
      console.log("array carrito " + this.arrayCarrito);
      const json = JSON.stringify(this.arrayCarrito);
      localStorage.setItem("carrito", json);
    },
    borrarCarrito(id) {
      console.log(id);
      this.arrayCarrito = this.arrayCarrito.filter(
        (articuloCarrito) => articuloCarrito.article.id != id
      );
      const json = JSON.stringify(this.arrayCarrito);
      localStorage.setItem("carrito", json);
    },
    incrementarCantidadCarrito(id) {
      console.log(id);
      const articuloCarrito = this.arrayCarrito.find(
        (articuloCarrito) => articuloCarrito.article.id == id
      );
      if (articuloCarrito) {
        if (articuloCarrito.amount < articuloCarrito.article.stock) {
          articuloCarrito.amount += 1;
        }
        const json = JSON.stringify(this.arrayCarrito);
        localStorage.setItem("carrito", json);
      }
    },
    decrementarCantidadCarrito(id) {
      console.log(id);
      const articuloCarrito = this.arrayCarrito.find(
        (articuloCarrito) => articuloCarrito.article.id == id
      );
      if (articuloCarrito) {
        if (articuloCarrito.amount > 1) {
          articuloCarrito.amount -= 1;
        }
        const json = JSON.stringify(this.arrayCarrito);
        localStorage.setItem("carrito", json);
      }
    },
    getLocalStorage() {
      return JSON.parse(localStorage.getItem("carrito"));
    },
    vaciarStorage() {
      localStorage.removeItem("carrito");
      this.arrayCarrito = [];
    },
    formatCurrency(currency) {
      const format = new Intl.NumberFormat("en-US", {
        style: "currency",
        currency: "USD",
      });

      return format.format(currency);
    },
    sendCarritoBack(array) {
      const newArray = array.reduce((result, item) => {
        result.push({ modId: item.article.id, amount: item.amount });


        return result;
      }, []);
      console.log(newArray);

      console.log(typeof newArray);

      axios.post("/api/modPurchase/PDF", newArray,{ responseType: 'arraybuffer' })
      .then(res =>{
        console.log(res);
          this.status = res.status;


          if (this.status === 200) { 
            // Crear un blob a partir de los datos de respuesta para crear un archivo descargable
            const blob = new Blob([res.data], { type: 'application/pdf' });
    
           // Crea una URL temporal para el objeto Blob
            const url = URL.createObjectURL(blob);
    
            // Crear un elemento de enlace para activar la descarga
            const link = document.createElement('a');
            link.href = url;
            link.download = 'BMW_Shopping_CART.pdf';
            link.click();
    
           // Limpiar la URL temporal
            URL.revokeObjectURL(url);
            this.vaciarStorage();
            
      }  } )
      .catch(err =>{
        console.log(err)
      })
    },
  },
  computed: {
    funcionPrecioTotal() {
      return this.arrayCarrito.reduce(
        (acumulador, item) => acumulador + item.article.price * item.amount,
        0
      );
    },
  },
}).mount("#app");
