<script>
import Vue from 'vue';

export default {

  data() {
    return {
      open: false,
      current: 0,
      selection: ""
    }
  },

  props: {
    suggestions: {
      type: Array,
      required: true
    },
    filter: {
      type: String,
      required: true
    }
  },

  computed: {
    matches() {
      if(this.selection)
        return this.suggestions.filter((restaurant) => {
          return restaurant[this.filter].toLowerCase().indexOf(this.selection.toLowerCase()) >= 0;
        });
    },

    openSuggestion() {
      return this.selection !== "" &&
      this.matches.length != 0 &&
      this.open === true;
    }
  },

  methods: {
    enter() {
      this.selection = this.matches[this.current][this.filter];
      this.$emit('choice', this.matches[this.current]);
      this.open = false;
    },

    up() {
      if(this.current > 0)
      this.current--;
    },

    down() {
      if(this.current < this.suggestions.length - 1)
      this.current++;
    },

    isActive(index) {
      return index === this.current;
    },

    change() {
      if (this.open == false) {
        this.open = true;
        this.current = 0;
      }
    },

    suggestionClick(index) {
      console.log(index);
      this.selection = this.matches[index][this.filter];
      this.$emit('choice', this.matches[index]);
      this.open = false;
    },
  }
}

</script>

<template>
  <div style="position:relative" v-bind:class="{'open':openSuggestion}">
    <input class="form-control" type="text" v-model="selection"
    @keydown.enter = 'enter'
    @keydown.down = 'down'
    @keydown.up = 'up'
    @input = 'change'
    />
    <ul class="dropdown-menu" style="width:100%">
      <li v-for="(suggestion,index) in matches" v-bind:class="{'active': isActive(index)}" @click="suggestionClick(index)">
        <a href="#">{{ suggestion.name }}</a>
      </li>
    </ul>
  </div>
</template>

<style lang="scss" scoped>
  input{
    background: rgba(0, 0, 0, 0.25);
    border: none;
    color: white;
    text-align: center;
  }
</style>
