<template>
  <div class="front-page">
    <lp-header class="lite"></lp-header>
    <router-view></router-view>
    <lp-footer class="lite"></lp-footer>
  </div>
</template>

<script>

import 'font-awesome/css/font-awesome.css';
import 'bootstrap/dist/css/bootstrap.min.css';

import Header from './Header';
import Footer from './Footer';

export default {
  components: {
    'lp-header' : Header,
    'lp-footer' : Footer
  }
};

</script>

<style lang="scss">
  .row{
    margin: 0;
  }
</style>

<style lang="scss" scoped>

  .front-page{
    color: #2c2d30;
    //background: url('/static/bg.jpg') no-repeat fixed center;
    min-height: 100%;
    height: 100%;
    //background-size: cover;
  }

  /*.front-page::before{
    content: '';
    position: absolute;
    height: 100%;
    width: 100%;
    background: rgba(0, 0, 0, 0.1);
  }*/

</style>
