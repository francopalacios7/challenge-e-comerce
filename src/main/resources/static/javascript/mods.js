const { createApp } = Vue;

createApp({
  data() {
    return {
        mods: [],
    };
  },
  created(){
    this.getMods()
  },
  methods: {
    getMods(){
        axios.get("/api/mods")
        .then(response => {
            this.mods = response.data
            console.log(this.mods)
        })
    }
  },
}).mount("#app");
