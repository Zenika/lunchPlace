import Vue from 'vue'
import VueRouter from 'vue-router'
import ADMIN_ROUTES from './components/admin/Router.admin';
import FRONT_ROUTES from './components/Router.front';

Vue.use(VueRouter);

const routes = [
  ...ADMIN_ROUTES,
  ...FRONT_ROUTES,
  { path: '*', component: require('./components/Front')},
]

const router = new VueRouter({
  mode: 'history',
  routes
})

export default router;
