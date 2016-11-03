<template>
  <div class="content">
    <lp-day-restaurant></lp-day-restaurant>
    <lp-restaurants></lp-restaurants>
  </div>
</template>


<script>

  import Restaurants from './Restaurants';
  import DayRestaurant from './DayRestaurant';

  export default {
    components: {
      'lp-restaurants' : Restaurants,
      'lp-day-restaurant' : DayRestaurant,
    }
  };
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style lang="scss" scoped>

</style>
