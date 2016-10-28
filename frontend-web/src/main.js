import Vue from 'vue';
import App from './App';

/* eslint-disable no-new */
new Vue({
  el: '#app',
  template: '<App/>',
  components: { App },
  created: function(){
    fetch('/restaurants.json').then(data => console.log(data))
  },
});
