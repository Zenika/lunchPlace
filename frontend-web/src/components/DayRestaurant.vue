<template>
  <div id="today">
    <img v-bind:src="item.cover" alt="" />
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
#today{

  background: #41B883;
  display: flex;
  width: 100%;
  margin: 50px auto;

  img{

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
