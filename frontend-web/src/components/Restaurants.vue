<template>
  <div class="content">
    <h2>Les restaurants</h2>
    <ul>
      <li v-for="item in items">
        <lp-restaurant :item="item"></lp-restaurant>
      </li>
    </ul>
  </div>
</template>

<script>
import Restaurant from './Restaurant';

export default {
  components: {
    'lp-restaurant': Restaurant
  },
  created: function(){
    console.log(process.env.API_URL)
    fetch(`${process.env.API_URL}/teams/1/restaurants/`).then(response => response.json()).then(data => this.items = data);
  },
  data() {
    return {
      items: []
    };
  },
};
</script>

<style lang="scss" scoped>

  h2{
    color: white;
    margin-bottom: 40px;
  }
  ul{

    display: flex;
    justify-content: space-between;
    flex-wrap: wrap;
    width: 100%;

    li{
      min-width: 22%;
      width: 300px;
      max-width: 100%;
      margin-bottom: 50px;
    }
  }
</style>
