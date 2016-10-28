<template>
  <ul>
    <li v-for="item in items">
      <restaurant v-bind:item="item"></restaurant>
    </li>
  </ul>
</template>

<script>
import Restaurant from './Restaurant';

export default {
  name: 'restaurants',
  components: {
    Restaurant
  },
  props: ['items'],
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>