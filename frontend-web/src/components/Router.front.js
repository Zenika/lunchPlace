const FRONT_ROUTES = [{
    path: '/',
    component: require('./Front'),
    children: [
        { path: '', component: require('./Vote') },
        { path: 'today', component: require('./DayRestaurant') },
        { path: 'home', component: require('./Home') },
        { path: 'signin'},
        { path: 'restaurants', component: require('./Restaurants') },
        { path: 'vote', component: require('./Vote') },

        { path: 'organisation/:org', component: require('./Organisation')},
        { path: 'organisation/:org/teams', component: require('./Teams') },
        { path: 'organisation/:org/team/:team', component: require('./Teams') },
        { path: 'organisation/:org/users', component: require('./Vote') },
        { path: 'organisation/:org/restaurants', component: require('./Restaurants') }

    ]
}];

export default FRONT_ROUTES;
