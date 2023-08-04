const { createApp } = Vue;

createApp({
  data() {
    return {
      registerClient:{
        firstName: '',
        lastName: '',
        address: '',
        phone: '',
        email: '',
        password:''
      },
      showConfirmation: false,
      err: ''
    }
  },
  methods: {


    register() {
      this.showConfirmation = true
    },
    confirmRegister() {
      this.showConfirmation = false;
  
      axios.post('/api/clients', this.registerClient)
        .then((res) => {
          if (res.status === 201) {
            this.showNotification('Account Created', 'success');
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
    cancelRegister() {
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