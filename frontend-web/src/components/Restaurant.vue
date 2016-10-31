<template>
  <div class="restaurant">
    <img :src="item.cover" alt="" />
    <div class="info">
      <span class="name">{{item.name}}</span>
      <span class="address">{{item.address}}</span>
      <span class="tel">{{item.tel}}</span>
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

    background: #41B883;
    display: flex;
    height: 150px;

    img{
      height: 100%;
      width: auto;
    }
    .info{

      padding: 10px;

      > *{
        display: block;
      }
      .name{
        font-size: 30px;
        text-align: center;
      }
      .address{

      }
      .tel{

      }
    }
  }
</style>
