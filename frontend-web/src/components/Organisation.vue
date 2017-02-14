<template>
  <div class="content" v-if="organisation">
    <h1>{{organisation.name}}</h1>

    <h2>Mes Équipes</h2>

    <div class="row" v-if="teams">
      <div class="col-md-2">
        <h3>Ma favorite <i class="fa fa-star" aria-hidden="true"></i></h3>
        <ul class="list_teams">
          <router-link tag="li" to="team/les-stagiaires/" class="team_bloc" v-bind:style="{ background: teams[1].color }">
            <a>
              <h4>{{teams[1].name}}</h4>
              <div class="footer">
                <span><i class="fa fa-user-o" aria-hidden="true"></i> {{teams[1].nb}}</span>
                <span>{{teams[1].rest}} <i class="fa fa-cutlery" aria-hidden="true"></i></span>
              </div>
            </a>
          </router-link>
        </ul>
      </div>
      <div class="col-md-2">
        <h3>Ma dernière équipe</h3>
        <ul class="list_teams">
          <router-link tag="li" to="team/les-stagiaires/" class="team_bloc" v-bind:style="{ background: teams[0].color }">
            <a>
              <h4>{{teams[0].name}}</h4>
              <div class="footer">
                <span><i class="fa fa-user-o" aria-hidden="true"></i> {{teams[0].nb}}</span>
                <span>{{teams[0].rest}} <i class="fa fa-cutlery" aria-hidden="true"></i></span>
              </div>
            </a>
          </router-link>
        </ul>
      </div>
      <div class="col-md-8">
        <h3>Les autres</h3>
        <ul class="list_teams">
          <router-link tag="li" to="team/les-stagiaires/" v-for="team in teams" class="team_bloc" v-bind:style="{ background: team.color }">
            <a>
              <h4>{{team.name}}</h4>
              <div class="footer">
                <span><i class="fa fa-user-o" aria-hidden="true"></i> {{team.nb}}</span>
                <span>{{team.rest}} <i class="fa fa-cutlery" aria-hidden="true"></i></span>
              </div>
            </a>
          </router-link>
        </ul>
      </div>
    </div>
    <div v-if="!teams">
      Pas de teams :'(
    </div>

    <h2>Utilisateurs</h2>
    <div class="row" v-if="users">
      <div class="col-md-12">
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
    </div>
    <div v-if="!users">
      Pas de teams :'(
    </div>
  </div>
</template>

<script>

import auth from '../auth'

export default {
  data(){
    return {
      organisation : null,
      teams : null,
      users : null
    };
  },
  created(){
    let orga_url = '/static/orga/organisation.json';
    let teams_url = '/static/orga/teams.json';
    let users_url = '/static/orga/users.json';

    this.$http.get(orga_url).then(response => {
      this.organisation = response.body;
    });

    this.$http.get(teams_url).then(response => {
      this.teams = response.body;
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

  h1{
    text-align: center;
  }

  .fa-star{
    color: gold;
  }

  padding: 30px;
  padding-top: 100px;
  color: #2c2d30;

  h2{
  }

  .list_teams{

    display: flex;
    justify-content: space-around;
    flex-wrap: wrap;

    a{
      color: white;
    }

    .team_bloc{
      display: block;
      margin-top: 20px;
      width: 220px;
      color: white;
      border-radius: 5px;
      margin-bottom: 10px;

      h4{
        text-align: center;
        margin: 40px;
      }

      .footer{
        background: rgba(0, 0, 0, 0.2);
        padding: 10px;
        border-bottom-right-radius: 5px;
        border-bottom-left-radius: 5px;
        display: flex;
        justify-content: space-between;
      }
    }
  }

  .list_users{

    display: flex;
    justify-content: space-around;
    flex-wrap: wrap;
    padding-top: 20px;

    .user_bloc{

      text-align: center;

      h4{
        margin-bottom: 0;
      }

      .avatar{
        border: solid 2px #2c2d30;
        border-radius: 50%;
        width: 100px;
        height: 100px;
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
