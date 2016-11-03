<template>
  <div id="app">
    <router-view></router-view>
  </div>
</template>

<script>

export default {
  name: 'app'
};
</script>

<style lang="scss">
  html,body{
    margin: 0;
    padding: 0;
    height: 100%;
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
    height: 100%
  }

  ul{
    margin: 0;
    padding: 0;
  }
  li{
    list-style: none;
  }
</style>
