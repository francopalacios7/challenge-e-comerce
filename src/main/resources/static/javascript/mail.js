const { createApp } = Vue;

createApp({
  data() {
    return {
        email:{
            header: '',
            message: '',
            file:null,
          },
      showConfirmation: false,
      err: ''
    }
  },
  methods: {
    onFileChange(event) {
      // Capture the selected file
      this.email.file = event.target.files[0];
    },

    sendEmail() {
      this.showConfirmation = true
    },
    confirmSendEmail() {

      console.log(typeof this.email.file)
        this.showConfirmation = false;
  
        const formData = new FormData();
        formData.append('header', this.email.header);
        formData.append('message', this.email.message);
        formData.append('file', this.email.file);
      
     /*    console.log(formData);  */
     
/*      axios.post('/api/transactions', 'amount=' + this.amount + '&description=' + this.description + '&originAcc=' + this.accountSelected + '&destinAcc=' + this.accChosen, */



        axios.post('/api/email',formData, {headers: {
          'Content-Type': 'multipart/form-data'} // Set the proper content type for the file upload
        })
          .then((res) => {
            if (res.status === 201) {
              this.showNotification('Email Created', 'success');
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