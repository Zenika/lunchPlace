import auth from '../auth';

const FRONT_ROUTES = [{
    path: '/',
    component: require('./Front'),
    base: __dirname,
    children: [
        { path: '', component: require('./Home') },
        { path: 'home', component: require('./Home') },
        { path: 'login', component: require('./Login'),beforeEnter: checkNotAuth },

        { path: 'me', component: require('./Me'),beforeEnter: checkAuth ,children: [
          { path: 'settings', component: require('./me/Settings') },
          { path: 'notifications', component: require('./me/Notifications') },
          { path: 'profile', component: require('./me/Profile') },
        ]},

        { path: 'organisations/', component: require('./Organisations') ,beforeEnter: checkAuth},
        { path: 'organisation/:org', component: require('./Organisation'),props: true ,beforeEnter: checkAuth},

        { path: 'organisation/:org/team/:team', component: require('./Team'),beforeEnter: checkAuth },
        { path: 'organisation/:org/users', component: require('./Vote'),beforeEnter: checkAuth },
        { path: 'organisation/:org/restaurants', component: require('./Restaurants'),beforeEnter: checkAuth },

        { path: 'today', component: require('./DayRestaurant'),beforeEnter: checkAuth },
        { path: 'restaurants', component: require('./Restaurants'),beforeEnter: checkAuth },
        { path: 'vote', component: require('./Vote'),beforeEnter: checkAuth }

    ]
}];

function checkAuth(to, from, next) {
	if (!auth.authenticated) {
		next('/login')
	} else {
		next()
	}
}
function checkNotAuth(to, from, next) {
	if (!auth.authenticated) {
    next()
	} else {
    next('/home')
	}
}

export default FRONT_ROUTES;
