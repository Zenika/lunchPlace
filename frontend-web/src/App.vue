<template>
  <div id="app">
    <ul>
      <li v-for="item in items">
        <restaurant v-bind:item="item"></restaurant>
      </li>
    </ul>
  </div>
</template>

<script>
import Restaurant from './components/Restaurant';

export default {
  name: 'app',
  components: {
    Restaurant,
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
