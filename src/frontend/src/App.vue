<template>
  <div id="app">
    <img alt="Vue logo" src="./assets/logo.png">
    <HelloWorld msg="Welcome to Your Vue.js App"/>
  </div>
</template>

<script>
import HelloWorld from './components/HelloWorld.vue'
import axios from 'axios'


export default {
  name: 'app',
  components: {
    HelloWorld
  },
  methods: {
    getBoardList(page){
      axios.get("/boards", {
        params : {
          start: page,
          length: 10
        }
      }).then(response => {
        this.list = response.data.list;
        this.totalCount = response.data.count;
        console.log(this.list);
        console.log(this.totalCount);
        console.log('ReTest')
      })
      .catch(error => {
        console.log('***** Error Log : ', error);
      });
    }
  },
  created() {
    console.log('*** App.Vue 동작');
    this.getBoardList(1);
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
