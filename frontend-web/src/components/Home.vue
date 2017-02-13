<template>
  <div class="content">
    <h2>Une application de nourriture pour les équipes qui changent le monde !!!</h2>

    <div class="home_bloc" v-if="!authenticated">
      <form class="form">
        <input type="email" name="email" placeholder="Votre email">
        <input class="success" type="button" name="name" value="Créer une organisation">
      </form>
      <br>
      <p>Votre organisation utilise déjà Lunch Place ? <router-link to="/login">Se connecter</router-link> ou <router-link to="/find-team">chercher votre organisation</router-link></p>
    </div>

    <router-link to="/organisations" class="vote_bloc" v-if="authenticated">
      JE VOTE
    </router-link>

  </div>
</template>


<script>
import auth from '../auth'

export default {
  data() {
    return {
      authenticated: auth.authenticated,
    };
  },
  created(){
    auth.checkAuth();
  }

};
</script>

<style lang="scss" scoped>
.content{

  padding-top: 15%;

  h2{
    color: #2c2d30;
    width: 100%;
    max-width: 800px;
    text-align: center;
    display: block;
    margin: auto;
    font-size: 3em;
    line-height: 80px;
    margin-bottom: 50px;
  }

  .vote_bloc{
    display: block;
    background: #0EB984;
    color: white;
    width: 80%;
    max-width: 400px;
    margin: auto;
    text-align: center;
    padding: 20px;
    font-size: 3em;
    font-weight: bold;
  }

  .home_bloc{
    width: 400px;
    max-width: 80%;
    padding: 20px 20px;
    text-align: center;
    display: block;
    margin: auto;
    background: rgba(0, 0, 0, 0.65);
    color: white;
    border-radius: 10px;

    input[type=url], input[type=text], input[type=tel], input[type=number], input[type=email], input[type=password], select, textarea{
      font-size: 1.25rem;
      line-height: 3.749rem;
      padding: 0 22px;
      border: 1px solid #C5C5C5;
      border-radius: .25rem;
      -webkit-appearance: none;
      -moz-appearance: none;
      appearance: none;
      outline: 0;
      color: #555459;
      max-width: 100%;
      margin: 0 0 .5rem;
      -webkit-transition: box-shadow 70ms ease-out,border-color 70ms ease-out;
      -moz-transition: box-shadow 70ms ease-out,border-color 70ms ease-out;
      transition: box-shadow 70ms ease-out,border-color 70ms ease-out;
      -webkit-font-smoothing: antialiased;
      -moz-osx-font-smoothing: grayscale;
      box-shadow: none;
      height: auto;
    }

    input{
      &.success{
        display: inline-block;
        font-size: 1.249rem;
        font-weight: 700;
        text-decoration: none;
        border: 1px solid #56B68B;
        border-radius: 4px;
        background: #41B883;
        color: #FFF;
        line-height: 3.749rem;
        padding: 0 22px;
      }
    }

    a{
      color: white;
      text-decoration: underline;
    }
  }
}
</style>
