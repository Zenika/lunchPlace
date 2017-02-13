<template>
  <div class="demo-layout mdl-layout mdl-js-layout mdl-layout--fixed-drawer mdl-layout--fixed-header">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:regular,bold,italic,thin,light,bolditalic,black,medium&amp;lang=en">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <header class="demo-header mdl-layout__header mdl-color--grey-100 mdl-color-text--grey-600">
      <div class="mdl-layout__header-row">
        <span class="mdl-layout-title">Home</span>
        <div class="mdl-layout-spacer"></div>
      </div>
    </header>
    <div class="demo-drawer mdl-layout__drawer mdl-color--blue-grey-900 mdl-color-text--blue-grey-50">
      <header class="demo-drawer-header">
        <img src="/static/user.jpg" class="demo-avatar">
        <div class="demo-avatar-dropdown">
          <span>hello@example.com</span>
          <div class="mdl-layout-spacer"></div>
          <button id="accbtn" class="mdl-button mdl-js-button mdl-js-ripple-effect mdl-button--icon">
            <i class="material-icons" role="presentation">arrow_drop_down</i>
            <span class="visuallyhidden">Accounts</span>
          </button>
          <ul class="mdl-menu mdl-menu--bottom-right mdl-js-menu mdl-js-ripple-effect" for="accbtn">
            <li class="mdl-menu__item"><a><i class="material-icons">add</i>My Account</a></li>
            <li class="mdl-menu__item"><a><i class="material-icons">add</i>Add another account...</a></li>
          </ul>
        </div>
      </header>
      <nav class="demo-navigation mdl-navigation mdl-color--blue-grey-800">
        <a class="mdl-navigation__link" href=""><i class="mdl-color-text--blue-grey-400 material-icons" role="presentation">home</i>Home</a>
        <router-link class="mdl-navigation__link" :to="{name: 'admin.list'}"><i class="mdl-color-text--blue-grey-400 material-icons" role="presentation">flag</i>Restaurants</router-link>
      </nav>
    </div>
    <main class="mdl-layout__content mdl-color--grey-100">
      <div class="mdl-grid demo-content">
        <div class="mdl-shadow--2dp mdl-color--white mdl-cell mdl-cell--12-col">
          <router-view></router-view>
        </div>
      </div>
      <button class="mdl-button mdl-js-button mdl-button--fab mdl-button--colored">
        <i class="material-icons">add</i>
      </button>
    </main>

  </div>
</template>

<script>
import 'material-design-lite';
import 'material-design-lite/dist/material.css';
import './admin.css';

export default {

};
</script>

<style lang="scss" scoped>
.mdl-button {
  position: fixed;
  bottom: 16px;
  right: 16px;
}
</style>
