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

<style lang="scss" scoped>

</style>
