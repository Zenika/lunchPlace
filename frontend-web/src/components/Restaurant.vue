<template>
  <div>
    <h2>{{ item.name }}</h2>
    <p> {{ item.address }}</p>
  </div>
</template>

<script>
export default {
  name: 'restaurant',
  props: ['item'],
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style lang="scss" scoped>
  $mint: #41B883;
  $cello : #35495E;

  div{
    background: $mint;
    color: $cello;
    display: inline-block;

    h2{

    }

    p{
      color: white;
    }
  }
</style>
