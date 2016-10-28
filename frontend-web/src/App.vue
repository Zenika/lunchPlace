<template>
  <div id="app">
    <img src="./assets/logo.png">
    <hello></hello> 
    <ul>
      <li v-for="item in items">bouh <restaurant v-bind:item="item"></restaurant></li>
    </ul>
  </div>
</template>

<script>
import Hello from './components/Hello';
import Restaurant from './components/Restaurant';

export default {
  name: 'app',
  components: {
    Hello, Restaurant,
  },
  data() {
    return {
      items: [
        { id: 1, name: 'L\'adresse', address: 'Lille' },
        { id: 1, name: 'L\'adresse', address: 'Lille' },
      ],
    };
  },
};
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
