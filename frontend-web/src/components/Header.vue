<template>
  <header>
    <router-link to="/" id="logo">
      <img src="/static/logo.png">
      <span>Lunch Place</span>
    </router-link>
    <ul id="nav">
      <li class="hidden"><router-link to="/vote">Je vote</router-link></li>
      <li><router-link to="/today">Le Restaurant</router-link></li>
      <li><router-link to="/restaurants">Les Restaurants</router-link></li>
      <li class="hidden"><router-link to="/" class="nav-link">Créer une team</router-link></li>
      <li class="hidden"><router-link to="/" class="nav-link">Chercher votre team</router-link></li>
      <li class="hidden"><router-link class="signin" to="/signin">Se connecter</router-link></li>
    </ul>
  </header>
</template>

<script>
export default {

};
</script>

<style lang="scss" scoped>

  header{
    position: relative;
    padding: 10px 0;
    box-shadow: 0 0 1px rgba(0,0,0,0.25);
    transition: background-color 0.3s ease-in-out;
    z-index: 2;

    #logo {
      display: inline-block;
      font-size: 2em;
      line-height: 40px;
      color: white;
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
      color:white;
      float: right;
      list-style: none;
      display: inline-block;
      font-size: 14px;
      line-height: 40px;


      li{
        display: inline-block;
        margin-left: 30px;
        a{
          color:white;
          font-size: 1em;
          font-weight: 900;
          border-radius: 5px;
          padding: 5px 8px;
          transition: all 0.3s;
        }
        a.signin{
          border: solid 2px white;
          border-radius: 5px;
          padding: 5px 8px;
        }
        a:hover{
          background: rgba(173, 173, 173, 0.4)
        }
      }


    }
  }

</style>
