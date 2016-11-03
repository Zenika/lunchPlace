
<template>
    <table class="mdl-data-table mdl-js-data-table mdl-shadow--2dp">
    <thead>
      <tr>
        <th class="mdl-data-table__cell--non-numeric">Restaurant</th>
        <th class="mdl-data-table__cell--non-numeric">Adresse</th>
        <th class="mdl-data-table__cell--non-numeric">Actions</th>
      </tr>
    </thead>
    <tbody>
      <tr v-for="item in items">
        <td class="mdl-data-table__cell--non-numeric">{{item.name}}</td>
        <td class="mdl-data-table__cell--non-numeric">{{item.address}}</td>
        <td>
          <button class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored">Modifier</button>
          <button class="mdl-button mdl-js-button mdl-button--raised mdl-button--accent">Supprimer</button>
        </td>
      </tr>
    </tbody>
  </table>


</template>

<script>
export default {
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
table {
    width: 100%;
}
</style>
