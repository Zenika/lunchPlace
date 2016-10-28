<template>
  <div id="app">
    <day-restaurant v-bind:item="selected"></day-restaurant> 
    <restaurants v-bind:items="items"></restaurants> 
  </div>
</template>

<script>
import Hello from './components/Hello';
import Restaurant from './components/Restaurant';
import Restaurants from './components/Restaurants';
import DayRestaurant from './components/DayRestaurant';

export default {
  name: 'app',
  components: {
    Hello, Restaurants, DayRestaurant
  },
  created: function(){
    fetch('http://localhost:8080/static/day-restaurant.json').then(response => response.json()).then(data => this.selected = data);
    fetch('http://localhost:8080/static/restaurants.json').then(response => response.json()).then(data => this.items = data);
  },
  data() {
    return {
      items: [],
      selected: {}
    };  
  }
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
