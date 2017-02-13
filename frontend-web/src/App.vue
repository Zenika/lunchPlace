<template>
  <router-view></router-view>
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
    font-family: Lato,Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    color: #2c3e50;
  }

  a{
    text-decoration: none!important;
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

    height: 100%
  }

  ul{
    margin: 0;
    padding: 0;
  }
  li{
    list-style: none;
  }

  .hidden{
    display: none;
  }
</style>
