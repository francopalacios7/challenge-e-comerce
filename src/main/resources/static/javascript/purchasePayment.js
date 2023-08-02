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
            .post("http://localhost:8080/api/cards/payment", {
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
        }
    }
}).mount('#app')