<template>
  <div id="app">
    <lp-header></lp-header>
    <div class="content">
      <lp-day-restaurant :item="selected"></lp-day-restaurant>
      <lp-restaurants :items="items"></lp-restaurants>
    </div>
  </div>
</template>
<script>

import Header from './components/Header';
import Restaurants from './components/Restaurants';
import DayRestaurant from './components/DayRestaurant';

export default {
  name: 'app',
  components: {
    'lp-restaurants': Restaurants,
    'lp-day-restaurant': DayRestaurant,
    'lp-header': Header
  },
  created() {
    fetch('http://localhost:8080/static/day-restaurant.json').then(response => response.json()).then((data) => {
      this.selected = data;
    });
    fetch('http://localhost:8080/static/restaurants.json').then(response => response.json()).then((data) => {
      this.items = data;
    });
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

html,body{
  margin: 0;
  padding: 0;
}

a {
  text-decoration: none;
  color: #34495e;
}
img {
  border: none;
}
h1,
h2,
h3,
h4,
strong {
  font-weight: 600;
  color: #2c3e50;
}

#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
}

.content{
  max-width: 1200px;
  width: 80%;
  margin: auto;
}

ul{
  margin: 0;
  padding: 0;
}
li{
  list-style: none;
}
</style>
