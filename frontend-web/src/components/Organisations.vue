<template>
  <div class="row content">
    <div class="col-md-4 left no-float">
      <h2>Vous êtes déja dans ces organisations :</h2>
      <ul>
        <li>
          <router-link to="/organisation/zenika-lille/">
            <img class="team_icon small" src="static/zenika.png"></img>
            <span>Zenika Lille <i class="fa fa-star" aria-hidden="true"></i></span>
            <i class="fa fa-angle-right" aria-hidden="true"></i>
          </router-link>
        </li>
        <li>
          <router-link to="/organisation/zenika-paris/">
            <img class="team_icon small" src="static/zenika.png"></img>
            <span>Zenika Paris</span>
            <i class="fa fa-angle-right" aria-hidden="true"></i>
          </router-link>
        </li>
        <li class="other">
          <router-link to="/">
            <i class="fa fa-search" aria-hidden="true"></i>
            Chercher une autre organisation
          </router-link>
        </li>

      </ul>
    </div>
    <div class="col-md-8 right no-float" v-bind:style="{ backgroundImage: 'url(static/img/bg' + random_bg + '.jpg)' }"></div>
  </div>
</template>


<script>

import auth from '../auth'

export default {
  data(){
    return {
      random_bg : Math.floor((Math.random() * 5) + 1)
    };
  },
  created(){
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style lang="scss" scoped>
.content{

  display: table;
  min-height: 100%;

  .no-float {
    display: table-cell;
    float: none;
  }
  .left{
    background: white;
    overflow: hidden;
    height: 100%;
  }
  .right{
    background-size: cover;
  }

  h2{
    font-size: 42px;
    font-weight: 300;
    color: black;
    width: 70%;
    margin: 150px auto 100px;
  }

  ul{

    height: 100%;
    width: 350px;
    margin: auto;
    max-width: 80%;

    li{
      background-color: transparent;
      font-size: 1.1875rem;
      display: block;
      line-height: 2.5rem;
      padding: 10px 15px 10px 11px;
      border: 1px #C7CACD solid;
      border-bottom-width: 0px;
      display: flex;
      width: 100%;
      align-items: center;
      justify-content: left;
      color: #555459;
      font-weight: 700;
      text-shadow: none;
      font-size: 19px;
      transition: all 0.2s;

      span{
        display: block;
        margin-right: auto;
      }

      &:hover{
        background: #f7f6f6;
        padding: 10px 10px 10px 11px;
      }

      a{
        color: #555459;
        width: 100%;
        display: flex;
        justify-content: space-between;
        align-items: inherit;
      }

      &.other{
        font-weight: normal;
        font-size: 14px;
        a{
          display: inline-block;
          i{
            margin: auto 25px;
          }
        }
      }

      &:first-of-type{
        border-top-left-radius: 6px;
        border-top-right-radius: 6px;
      }
      &:last-of-type{
        border-bottom-width: 1px;
        border-bottom-left-radius: 6px;
        border-bottom-right-radius: 6px;
      }

      .team_icon{
        margin-right: 20px;
        width: 50px;
      }

      .fa-star{
        margin-left: 20px;
        color: gold;
      }

    }
  }

  h2{
    color: black;
  }

}
</style>
