const { createApp } = Vue;

createApp({
  data() {
    return {
      turReservation: '',
      email: '',
      showConfirmation: false,
      err: ''
    }
  },

  created(){
  this.loadData();

},
  methods: {

    loadData(){
      axios.get('/api/clients/current')
      .then(res => {
        console.log(res)
        console.log("Email: "+res.data.email);
        this.email = res.data.email;
      });
    },

    requestTurn() {
      this.showConfirmation = true
    },
    confirmTurn() {
      this.showConfirmation = false;
  
      const transferData = {
        turReservation: this.turReservation,
        email: this.email
      };

      axios.post('/api/client/sendEmail',transferData)
        .then((res) => {
          if (res.status === 200) {
            this.showNotification('Requested shift', 'success');
            setTimeout(() => {
              window.location.href = './index.html';
            }, 700);
          }
        })
      .catch(error => {
        console.error(error);
        this.err = error.response.data;
        console.log(this.err)
          this.showNotification(this.err, 'error');

      });
    },
    cancelTurn() {
      this.showConfirmation = false;
    },

    showNotification(message, type) {
      const toast = document.createElement('div');
      toast.classList.add('toastify', type);
      toast.textContent = message;
      document.body.appendChild(toast);

      setTimeout(() => {
        toast.classList.add('show');
        setTimeout(() => {
          toast.classList.remove('show');
          setTimeout(() => {
            document.body.removeChild(toast);
          }, 300);
        }, 2000);
      }, 100);
    }
  }
}).mount('#app');