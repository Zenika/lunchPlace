<template>
  <header v-bind:class="get_header_class()">
    <router-link to="/" id="logo">
      <img src="/static/logo.png">
      <span>Lunch Place</span>
    </router-link>
    <ul id="nav" v-if="authenticated">
      <li><router-link to="/organisation/zenika-lille/team/les-stagiaires/">Je vote</router-link></li>
      <li><router-link to="/" class="nav-link">A propos</router-link></li>
      <li><router-link to="/" class="nav-link">Contact</router-link></li>
      <li>
        <a class="login" @click="logout()">
          Se déconnecter
          <i class="fa fa-sign-out" aria-hidden="true"></i>
        </a>
      </li>
      <li>
        <router-link v-if="user" class="me" to="/me/profile">
          <img :src="user.picture" alt="">
        </router-link>
      </li>
    </ul>
    <ul id="nav" v-if="!authenticated">
      <li><router-link to="/" class="nav-link">Créer une organisation</router-link></li>
      <li><router-link to="/" class="nav-link">A propos</router-link></li>
      <li><router-link to="/" class="nav-link">Contact</router-link></li>
      <li><a class="login" @click="login()">Se connecter</a></li>
    </ul>
  </header>
</template>

<script>
import auth from '../auth'

export default {
  data() {
    return {
      user : null,
      authenticated: auth.authenticated,
      random_bg : Math.floor((Math.random() * 5) + 1)
    };
  },
  created(){
    auth.checkAuth()
    if(this.authenticated){
      this.user = auth.getProfile()
    }
  },
  methods: {
    get_header_class(){
      let path = this.$route.path;
      console.log(path);
      if(path == "/organisations")
        return 'lite';
      else
        return 'grey';
    },
    login() {
      auth.lock.show();
    },
    logout(){
      auth.logout();
    }
  }
};
</script>

<style lang="scss" scoped>

header{
  padding: 10px 0;
  transition: background-color 0.3s ease-in-out;
  z-index: 2;
  width: 100%;
  padding: 4px 5%;
  position: absolute;
  color: #2c2d30;

  &.grey{
    background: #e2dede;
  }

  &.lite{

  }

  a{
    color: #2c2d30;
    transition: all 0.2s;
  }

  #logo {
    display: inline-block;
    font-size: 2em;
    line-height: 40px;
    font-family: 'Dosis', 'Source Sans Pro', 'Helvetica Neue', Arial, sans-serif;
    font-weight: 500;
  }

  #logo img {
    vertical-align: middle;
    margin-right: 6px;
    width: 40px;
    height: 40px;
    transform: rotate(180deg);
  }

  ul#nav{

    margin: 0px;
    float: right;
    list-style: none;
    display: inline-block;
    font-size: 14px;
    line-height: 40px;

    li{
      display: inline-block;
      margin-left: 30px;

      .me{
        border: solid 2px #2c2d30;
        border-radius: 50%;
        width: 40px;
        height: 40px;
        display: inline-block;
        padding: 0;
        vertical-align: top;
        overflow: hidden;

        img{
          width: 102%;
          margin-top: -7px;
        }
      }

      a{
        color:#2c2d30;
        font-size: 1em;
        font-weight: 900;
        border-radius: 5px;
        padding: 5px 8px;
        transition: all 0.3s;
      }
      a.login{
        border: solid 2px #2c2d30;
        border-radius: 5px;
        padding: 5px 8px;
        cursor: pointer;
        .fa{
          display: none;
          opacity: 0;
          visibility: 0;
        }
        &:hover{
          .fa{
            display: inline-block;
            opacity: 1;
            visibility: 1;
          }
        }
      }
      a:hover{
        //background: rgba(173, 173, 173, 0.4);
      }
    }


  }
}

</style>
