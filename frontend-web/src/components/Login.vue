<template>
  <section class="full" v-bind:style="{ backgroundImage: 'url(static/img/bg' + random_bg + '.jpg)' }">
    <div class="login_bloc">
      <h2>LunchPlace<br>Connexion</h2>
      <input class="success" type="button" value="Se connecter" @click="login()">
    </div>
  </section>
</template>


<script>

  import auth from '../auth';

  export default {

    methods: {

      login() {
        auth.lock.show((err, profile, id_token) => {
          localStorage.setItem('profile', JSON.stringify(profile))
          localStorage.setItem('id_token', id_token)
        })
      }
    },
    data() {
      return {
        authenticated: false,
        random_bg : Math.floor((Math.random() * 5) + 1)
      };
    },
    created(){

      auth.lock.show((err, profile, id_token) => {
        localStorage.setItem('profile', JSON.stringify(profile))
        localStorage.setItem('id_token', id_token)
        this.$router.push('home')
      });
    }
  };
</script>

<style lang="scss" scoped>

  section{

    min-height: 100%;
    display: block;
    position: absolute;
    width: 100%;
    background-size: cover;

    .login_bloc{
      max-width: 80%;
      width: 500px;
      padding: 20px 20px;
      text-align: center;
      display: block;
      margin: auto;
      background: white;
      color: black;
      border-radius: 10px;
      position: absolute;
      margin-top: -120px;
      left: 50%;
      top: 50%;
      margin-left: -250px;

      h2{

      }

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
