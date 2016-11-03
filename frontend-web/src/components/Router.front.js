const FRONT_ROUTES = [{
    path: '/',
    component: require('./Front'),
    children: [
        { path: '', component: require('./Home') },
        { path: 'restaurants', component: require('./Restaurants') },
        { path: 'vote', component: require('./Vote') }

    ]
}];

export default FRONT_ROUTES;
