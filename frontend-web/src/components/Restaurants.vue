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
    fetch('http://localhost:8080/static/restaurants.json').then(response => response.json()).then(data => this.items = data);
  },
  data() {
    return {
      items: []
    };
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
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
      min-width: 20%;
      width: 300px;
      max-width: 100%;
      margin-bottom: 50px;
    }
  }
</style>
