<template>
  <ul>
    <li v-for="item in items">
      <lp-restaurant v-bind:item="item"></lp-restaurant>
    </li>
  </ul>
</template>

<script>
import Restaurant from './Restaurant';

export default {
  components: {
    'lp-restaurant':Restaurant
  },
  props: ['items'],
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
