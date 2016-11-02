<template>
  <div>
    <lp-header></lp-header>   
    <router-view></router-view>
  </div>
</template>

<script>

import Header from './Header';

export default {
  components: {
    'lp-header' : Header
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style lang="scss" scoped>

</style>
