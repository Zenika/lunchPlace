<template>
  <div class="content">
    <lp-day-restaurant v-bind:item="selected"></lp-day-restaurant>
    <lp-restaurants v-bind:items="items"></lp-restaurants>
  </div>
</template>


<script>

  import Restaurants from './Restaurants';
  import DayRestaurant from './DayRestaurant';

  export default {
    components: {
      'lp-restaurants' : Restaurants,
      'lp-day-restaurant' : DayRestaurant,
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

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style lang="scss" scoped>
  ul{
    display: flex;
    justify-content: space-between;

    li{

    }
  }
</style>
