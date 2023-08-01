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
            this.mods = response.data.sort((a, b) => b.id - a.id);
            console.log("mods: ", this.mods)
        })
    }
  },
}).mount("#app");
