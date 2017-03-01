import Vue from 'vue';
import VueResource from 'vue-resource';
import App from './App';
import Router from './Router';
import auth from './auth';

/* https://github.com/auth0-blog/vue-jwt-authentication */

/* eslint-disable no-new */

Vue.use(VueResource);

Vue.http.interceptors.push((request, next)  => {
  //Ajout du token
  if(auth.checkAuth())
    request.headers['Authorization'] = auth.getAuthHeader();

  next((response) => {
    if(response.status == 401 ) {
      auth.logout();
      Router.push('/');
    }
  });

});

new Vue({
  el: '#app',
  template: '<App/>',
  router : Router,
  components: { App },
  created: function(){
  },
});
