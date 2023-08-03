

const { createApp } = Vue

createApp({
    data() {
        return {
            number: "",
            cvv: null,
            amount: null,
            description: ""
        }
    },
    created() {
    },
    methods: {
        cardPayment(){
            axios
            .post("http://localhost:4200/api/cards/payment", {
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
            axios.post("http://localhost:4200/api/pagos")
            .then(res => console.log(res))
            .catch(err => console.log(err))
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