const { createApp } = Vue;

createApp({
  data() {
    return {
      email: '',
      password:'',
      err: ''
    }
  },

  methods: {

    logIn() {
/* console.log(this.email + this.password) */
      axios.post('/api/login', `email=${this.email}&password=${this.password}`)
        .then((res) => {
          console.log(res)
          if(this.email.includes("admin")){
            window.location.href = './manager.html';
          } else {
            window.location.href= './index.html';
          }
        })
        .catch(error => {
      /*     console.error(error); */
          this.err = error.response.data.error;
         /*  console.log(this.err) */
          this.showNotification(this.err, 'error');
        });
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