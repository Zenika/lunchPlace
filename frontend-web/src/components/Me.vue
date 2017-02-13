<template>
  <div class="content">

    <div class="row">
      <div class="col-md-2">
        <lp-memenu></lp-memenu>
      </div>
      <div class="col-md-10 bloc">

        <h2>Mon compte</h2>


        <ul class="nav nav-tabs">
          <router-link tag="li" active-class="active" to="/me/settings"><a>Réglages</a></router-link >
          <router-link tag="li" active-class="active" to="/me/notifications"><a>Notifications</a></router-link >
          <router-link tag="li" active-class="active" to="/me/profile"><a>Profile</a></router-link >
        </ul>
        <router-view class="subbloc"></router-view>
      </div>
    </div>
  </div>
</template>


<script>
import auth from '../auth'
import Menu from './me/Menu';

export default {
  components: {
    'lp-memenu' : Menu,
  },
  data() {
    return {
      me : null,
      authenticated: auth.authenticated,
    };
  },
  created(){
    this.me = auth.getProfile();
    console.log(this.me);
  }

};
</script>

<style lang="scss" scoped>
.content{

  .row{
    margin: 0;
  }

  padding-top: 50px;

  h2{
    color: #2c2d30;
    width: 100%;
    max-width: 800px;
    text-align: left;
    font-size: 3em;
    line-height: 80px;
    margin-bottom: 50px;
  }

  .bloc{

    padding-top: 50px;

    & > *{
      width: 1200px;
      max-width: 90%;
      margin: auto;
    }
  }

}
</style>
