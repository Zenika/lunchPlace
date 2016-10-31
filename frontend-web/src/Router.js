import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter);

const routes = [
  { path: '/restaurants', component: require('./components/Restaurants')},
  { path: '/restaurant', component: require('./components/Restaurant')},
  { path: '/vote', component: require('./components/Vote')},
  { path: '/contact', component: require('./components/Contact')},
  { path: '*', component: require('./components/Home')},
]

const router = new VueRouter({
  mode: 'history',
  routes
})

export default router;
