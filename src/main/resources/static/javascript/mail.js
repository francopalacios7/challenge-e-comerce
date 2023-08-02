const { createApp } = Vue;

createApp({
  data() {
    return {
        email:{
            header: '',
            message: '',
            file: '',
          },
      showConfirmation: false,
      err: ''
    }
  },
  methods: {


    sendEmail() {
      this.showConfirmation = true
    },
    confirmSendEmail() {
        this.showConfirmation = false;
   /*    
        const formData = new FormData();
        formData.append('header', this.email.header);
        formData.append('message', this.email.message);
        formData.append('file', this.email.file);
      
        console.log(formData);  */
      
        axios.post('/api/email', {
            header: this.email.header,
            message: this.email.message,
            file: this.email.file
          }, {
            headers: {
              'Content-Type': 'application/x-www-form-urlencoded'
            }
          })
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
            console.log(this.err);
            this.showNotification(this.err, 'error');
          });
          
      },
    cancelSendEmail() {
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