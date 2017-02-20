<template>
  <div class="content">

    <header>
      <router-link id="all" to="/organisations">
        <span>Organisations</span>
      </router-link>
      <span> > </span>
      <router-link to="/organisation/zenika-lille/">
        <span id="orga">Zenika Lille</span>
      </router-link>
      <span> > </span>
      <span id="team">Les Stagiaires</span>
      <div class="actions">
        <button type="button" class="btn btn-success">Team par default <i class="fa fa-up" aria-hidden="true"></button>
        <button type="button" class="btn btn-gold">Ajouter au Favoris <i class="fa fa-star" aria-hidden="true"></button>
      </div>
    </header>

    <div class="hidden">
      <button type="button" class="btn btn-green">Rejoindre cette team <i class="fa fa-users" aria-hidden="true"></i></button>
    </div>

    <div class="vote">

      <div class="hidden current row" v-if="restaurants">
        <h2>Vote en cours</h2>
        <div class="col-md-4">
          <div class="place">
            2ème <i class="fa fa-trophy" aria-hidden="true" style="color:grey"></i>
            <lp-restaurant :item="restaurants[1]"></lp-restaurant>
          </div>
        </div>
        <div class="col-md-4">
          <div class="place">
            1er <i class="fa fa-trophy" aria-hidden="true" style="color:gold"></i>
            <lp-restaurant :item="restaurants[2]"></lp-restaurant>
          </div>
        </div>
        <div class="col-md-4">
          <div class="place">
            3ème <i class="fa fa-trophy" aria-hidden="true" style="color:#c74545"></i>
            <lp-restaurant :item="restaurants[0]"></lp-restaurant>
          </div>
        </div>
      </div>

      <div class="" v-if="restaurants">
        <h2>Voter</h2>
        <div class="row voteprogress">
          <div class="col-md-4 plus">
            <h2>+1</h2>
            <lp-autocomplete :suggestions="restaurants" :filter="'name'" v-on:choice="pour = $event"></lp-autocomplete>
            <div class="result">
              <p v-if="!pour" class="nochoice">Non choisis</p>
              <p v-if="pour" class="choice">
                <img v-bind:src="pour.cover" alt="">
                {{pour.name}}<br>
                {{pour.address}}
              </p>
            </div>
          </div>
          <div class="col-md-4 bof">
            <h2>=</h2>
            <lp-autocomplete :suggestions="restaurants" :filter="'name'" v-on:choice="whynot = $event"></lp-autocomplete>
            <div class="result">
              <p v-if="!whynot" class="nochoice">Non choisis</p>
              <p v-if="whynot" class="choice">
                <img v-bind:src="whynot.cover" alt="">
                {{whynot.name}}<br>
                {{whynot.address}}
              </p>
            </div>
          </div>
          <div class="col-md-4 moins">
            <h2>-1</h2>
            <lp-autocomplete :suggestions="restaurants" :filter="'name'" v-on:choice="contre = $event"></lp-autocomplete>
            <div class="result">
              <p v-if="!contre" class="nochoice">Non choisis</p>
              <p v-if="contre" class="choice">
                <img v-bind:src="contre.cover" alt="">
                {{contre.name}}<br>
                {{contre.address}}
              </p>
            </div>
          </div>
        </div>
      </div>
    </div>

    <div class="row">
      <div class="col-md-4" v-if="users">
        <h2>Les Utilisateurs</h2>
        <ul class="list_users">
          <li v-for="user in users" class="user_bloc">
            <div class="avatar">
              <img v-bind:src="user.avatar" alt="">
            </div>
            <h4>{{user.firstname}}<br>{{user.lastname}}</h4>
            <em>{{user.poste}}</em>
          </li>
        </ul>
      </div>

      <div class="col-md-4 restaurants" v-if="restaurants">
        <h2>Les Restaurants</h2>
        <ul>
          <li v-for="restaurant in restaurants">
            <lp-restaurant :item="restaurant"></lp-restaurant>
          </li>
        </ul>
      </div>

      <div class="col-md-4 historique" v-if="restaurants">
        <h2>Historique</h2>
        <ul>
          <li v-for="restaurant in restaurants">
            <p>Le 10/10/16 :</p>
            <lp-restaurant :item="restaurant"></lp-restaurant>
          </li>
        </ul>
      </div>
    </div>

  </div>
</template>

<script>

import auth from '../auth'
import Restaurant from './Restaurant'
import Autocomplete from './shared/Autocomplete.vue';

export default {
  components: {
    'lp-autocomplete' : Autocomplete,
    'lp-restaurant': Restaurant
  },
  data(){
    return {
      value: "",
      pour: "",
      contre: "",
      whynot: "",
      history: null,
      users: null,
      restaurants: null
    };
  },
  created(){
    let history_url = '/static/restaurants.json';
    let restaurants_url = '/static/restaurants.json';
    let users_url = '/static/orga/users.json';

    this.$http.get(history_url).then(response => {
      this.history = response.body;
    });

    this.$http.get(restaurants_url).then(response => {
      this.restaurants = response.body;
    });

    this.$http.get(users_url).then(response => {
      this.users = response.body;
    });
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style lang="scss" scoped>
  .content{

    header{
      background: #f9f2f2;
      padding: 15px;

      a{
        color: #2c2d30;
      }

      & > * {
        display: inline-block;
      }
      #all{
        font-size: 22px;
      }
      #orga{
        font-size: 20px;
      }
      #team{
        font-size: 18px;
      }
      .actions{
        float: right;
      }
    }

    padding: 30px;
    padding-top: 100px;
    color: #2c2d30;

    h1{
      text-align: center;
    }

    .btn-gold{
      color: black;
      background: gold;
      .fa-star{
        color: black;
      }
    }

    .row > div{
      padding: 30px;
    }

    .vote{

      .voteprogress{

        margin: 20px 0 0px;

        h2{
          color: white;
          margin-top: 0px;
          text-align: center;
        }

        .plus{
          background: #41B883;
        }

        .bof{
          background: #5BC0DE;
        }

        .moins{
          background: #E35150;
        }

        .result{

          color: white;
          //min-height: 50px;

          .nochoice{
            text-align: center;
            padding-top: 30px;
            font-size: large;
          }
          .choice{
            padding-top: 30px;
            img{
              width: 50%;
              max-width: 200px;
              float: left;
              margin-right: 20px;
            }
            font-weight: bold;
          }
        }

      }


      .current{
        margin: auto;
        max-width: 80%;
        width: 800px;
        text-align: center;
        font-size: 30px;

        & > div:first-of-type{
          margin-top: 50px;
        }
        & > div:last-of-type{
          margin-top: 80px;
        }

        .restaurant{
          margin-top: 20px;
        }
      }
    }

    .restaurants{
      ul{
        //max-height: 300px;
        overflow-x: scroll;
        background: #f9f2f2;
        padding: 10px;
        li{
          margin-top: 20px;
        }
      }
    }

    .historique{
      ul{
        background: #f9f2f2;
        padding: 10px;
        //max-height: 300px;
        overflow-x: scroll;
      }
      p{
        font-weight: bold;
        margin-top: 20px;
      }
    }

    .list_users{

      display: flex;
      justify-content: space-around;
      flex-wrap: wrap;
      padding-top: 20px;
      background: #f9f2f2;
      //max-height: 300px;
      overflow-x: scroll;

      .user_bloc{

        text-align: center;
        margin: 10px 20px;

        h4{
          margin-bottom: 0;
        }

        .avatar{
          border: solid 2px #2c2d30;
          border-radius: 50%;
          width: 50px;
          height: 50px;
          display: inline-block;
          padding: 0;
          vertical-align: top;
          overflow: hidden;

          img{
            width: 102%;
          }
        }

      }
    }

  }
</style>
