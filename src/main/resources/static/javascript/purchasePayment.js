

const { createApp } = Vue

createApp({
    data() {
        return {
            number: "",
            cvv: null,
            amount: null,
            description: "",
            arrayCarrito: []
        }
    },
    created() {
      this.arrayCarrito = JSON.parse(localStorage.getItem("carrito")) ?? [];
    },
    methods: {
        cardPayment(){
            axios
            .post("https://homebanking-bj27.onrender.com/api/cards/payment", {
                "number": this.number,
                "cvv": this.cvv,
                "amount": this.amount,
                "description": this.description
            })
            .then(res => {
                console.log("pago");
                this.number = ""
                this.cvv = null
                this.amount = null
                this.description = ""
            })
            .catch(err => console.log(err))
        },
        page(){
            axios.post("https://homebanking-bj27.onrender.com/api/pagos")
            .then(res => console.log(res))
            .catch(err => console.log(err))
        },
        vaciarStorage() {
          localStorage.removeItem("carrito");
        },
        descargarPDF(newArray){
          
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
        confirmOperation() {
            const swalWithBootstrapButtons = Swal.mixin({
              customClass: {
                confirmButton: 'btn btn-success',
                cancelButton: 'btn btn-danger'
              },
              buttonsStyling: false
            })
      
            swalWithBootstrapButtons.fire({
              title: 'Are you sure?',
              text: "You are about to make a new payment.",
              icon: 'warning',
              showCancelButton: true,
              confirmButtonText: 'Yes, create.',
              cancelButtonText: 'No, cancel.',
              reverseButtons: true
            }).then((result) => {
              if (result.isConfirmed) {
                swalWithBootstrapButtons.fire(
                  'Payment succesfully done!',
                  'See you soon.',
                  'success',
                  console.log("payment created!!!"),
                  this.cardPayment(),
                  this.vaciarStorage(),
                  this.descargarPDF(this.arrayCarrito),
                  //window.location.href = "/web/index.html"
      
                )
              } else if (
                /* Read more about handling dismissals below */
                result.dismiss === Swal.DismissReason.cancel
              ) {
                swalWithBootstrapButtons.fire(
                  'Cancelled',
                  'No payment done :)',
                  'error'
                )
              }
            })
          }
    }
}).mount('#app')