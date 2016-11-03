<template>
  <div class="restaurant">
    <div class="cover" v-bind:style="{ backgroundImage: 'url(' + item.cover + ')' }"alt="">
      <div class="distance">200m</div>
    </div>
    <div class="sep"></div>
    <div class="content">
      <span class="icon"><i class="fa fa-cutlery"></i></span>
      <span class="name">{{item.name}}</span>
      <span class="address">{{item.address}}</span>
      <!--<span class="tel">{{item.tel}}</span>-->
    </div>
  </div>
</template>

<script>
export default {
  props: ['item'],
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style lang="scss" scoped>
  $mint: #41B883;
  $cello : #35495E;

  .restaurant{

    background: white;
    height: 150px;
    border-radius: 5px;
    box-shadow: 0px 7px 20px 0px rgba(50, 50, 50, 1);
    overflow: hidden;

    .cover{
      height: 100%;
      width: auto;
      height: 60%;
      background-size: cover;
      background-position: center center;
      position: relative;

      .distance{
        position: absolute;
        color: white;
        border-radius: 5px;
        font-size: 10px;
        line-height: 14px;
        background-color: rgba(0, 0, 0, 0.5);
        top: 5px;
        left: 5px;
        padding: 1px 3px;
        text-align: center;
        font-weight: 700;
      }
    }

    .sep{
      width: 100%;
      height: 5px;
      background-image: url('/static/pointer_sep.png');
      background-repeat: repeat-x;
      margin-top: -5px;
    }

    .content{

      padding: 10px;
      position: relative;
      background: white;

      > *{
        display: block;
      }

      .icon{
        background-color: #FF922B;
        height: 40px;
        width: 40px;
        display: inline-block;
        float: left;
        border-radius: 16px;
        margin-right: 12px;
        text-align: center;

        i{
          font-size: 20px;
          line-height: 40px;
        }
      }

      .name{
        font-size: 20px;
        font-weight: 800;
        text-align: left;
        color:#4E422F;
      }
      .address{
        color: #BFB9B4;
        font-size: 13px;
        line-height: 16px;
      }
      .tel{

      }
    }
  }
</style>
