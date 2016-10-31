<template>
  <div id="app">
    <lp-header></lp-header>
    <router-view></router-view>
  </div>
</template>

<script>

import Header from './components/Header';

export default {
  name: 'app',
  components: {
    'lp-header' : Header
  }
};
</script>

<style>
  html,body{
    margin: 0;
    padding: 0;
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
  }

  .content{
    max-width: 1200px;
    width: 80%;
    margin: auto;
  }

  ul{
    margin: 0;
    padding: 0;
  }
  li{
    list-style: none;
  }
</style>
