<template>
  <div class="content">
    <h2>Mon organisation : {{ $route.params.org }}</h2>

  </div>
</template>


<script>
  export default {

  };
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style lang="scss" scoped>
  .content{

    padding-bottom: 50px;

    h2{
      color: white;
    }

  }
</style>
