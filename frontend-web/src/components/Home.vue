<template>
  <div class="content">
    <h2>Une application de nourriture pour les équipes qui changent le monde !!!</h2>

    <div class="home_bloc">
      <form class="form">
        <input type="email" name="email" placeholder="Votre email">
        <input class="success" type="button" name="name" value="Créer une team">
      </form>
      <p>Votre team utilise déjà Lunch Place ? <router-link to="/signin">Se connecter</router-link> ou <router-link to="/find-team">chercher votre team</router-link></p>
    </div>

  </div>
</template>


<script>
  export default {

  };
</script>

<style lang="scss" scoped>
  .content{

    padding-bottom: 50px;

    h2{
      color: white;
      width: 100%;
      max-width: 800px;
      text-align: center;
      display: block;
      margin: 10% auto;
      line-height: 80px;
    }

    .home_bloc{
      width: 100%;
      max-width: 500px;
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
