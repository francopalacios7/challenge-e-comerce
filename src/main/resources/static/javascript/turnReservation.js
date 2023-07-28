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
  methods: {

    requestTurn() {
      this.showConfirmation = true
    },
    confirmTurn() {
      this.showConfirmation = false;
  
      const transferData = {
        turReservation: this.turReservation,
        email: "correalucasmatias98@gmail.com"
      };

      axios.post('/api/client/sendemail',transferData)
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