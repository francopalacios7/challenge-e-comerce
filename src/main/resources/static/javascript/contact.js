const { createApp } = Vue;

createApp({
  data() {
    return {
    cars:[],
    params: '',
    meeting:{
        meetingReservation: '', //LocalDateTime del turno
        email: '',
        message: '',
        date: '2024',  //año del auto
        model:  'FZ 100',
      },
    showConfirmation: false,
    err: ''
    }
  },
  created(){

    /* this.params = new URLSearchParams(location.search).get("id"); */
    axios.get("/api/car")
        .then(response => {
                  
          this.cars = response.data;
            console.log(this.cars)
            console.log(this.meeting)
          /* this.carFiltrado = this.cars.filter(car => car.id == this.params)
          console.log("Cars:", this.cars);
          console.log("Cars Filtrados:", this.carFiltrado); */

        }).catch(error => {
          console.error(error);
          this.err = error.response.data;
          console.log(this.err)
          this.showNotification(this.err, 'error');
        });
    },
  methods: {
    meetingc() {
      this.showConfirmation = true
    },
    confirmMeeting() {
      this.showConfirmation = false;
  
      axios.post('/api/client/sendEmail', this.meeting)
        .then((res) => {
          if (res.status === 200) {
            this.showNotification('Meeting Confirmed', 'success');
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
    cancelMeeting() {
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