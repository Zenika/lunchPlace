<template>
  <div class="front-page">
    <lp-header></lp-header>
    <router-view></router-view>
  </div>
</template>

<script>

import Header from './Header';
import 'font-awesome/css/font-awesome.css';

export default {
  components: {
    'lp-header' : Header
  }
};
</script>

<style lang="scss" scoped>

  .front-page{
    background: url('/static/bg.jpg') no-repeat fixed center;
    min-height: 100%;
    background-size: cover;
    padding: 0 5%;
  }

  /*.front-page::before{
    content: '';
    position: absolute;
    height: 100%;
    width: 100%;
    background: rgba(0, 0, 0, 0.1);
  }*/

</style>
