<template>
  <section>
    <h2>{{ item.name }}</h2>
    <p> {{ item.address }}</p>
  </section>
</template>

<script>
export default {
  name: 'restaurant',
  props: ['item'],
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
</style>
