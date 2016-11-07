<template>
  <div class="today">
    <h2>Le restaurant du jour</h2>
    <div class="today_restaurant">
      <div class="cover" v-bind:style="{ backgroundImage: 'url(' + item.cover + ')' }"alt="" />
      <div class="sep"></div>
      <div class="content">
        <span class="icon"><i class="fa fa-cutlery"></i></span>
        <span class="name">{{item.name}}</span>
        <span class="address">{{item.address}}</span>
        <!--<span class="tel">{{item.tel}}</span>-->
      </div>
    </div>
  </div>
</template>

<script>
export default {
  created: function(){
    fetch('http://localhost:8080/static/day-restaurant.json').then(response => response.json()).then(data => this.item = data);
  },
  data() {
    return {
      item: {}
    };
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style lang="scss" scoped>
.today{

  h2{
    color: white;
    margin-bottom: 40px;
  }

  .today_restaurant{

    background: white;
    height: 350px;
    border-radius: 5px;
    box-shadow: 1px 1px 10px -2px #000000;
    overflow: hidden;
    width: 100%;
    margin: 40px auto;
    display: flex;

    .cover{
      height: 100%;
      width: 50%;
      background-size: cover;
      background-position: center center;
    }

    .sep{
      width: 5px;
      height: 100%;
      background-image: url('/static/pointer_sep_left.png');
      background-repeat: repeat-y;
      margin-left: -4px;
    }

    .content{

      padding: 10px;
      width: 50%;

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
}
</style>
