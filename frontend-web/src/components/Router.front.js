const FRONT_ROUTES = [{
    path: '/',
    component: require('./Front'),
    children: [
        { path: '', component: require('./Home') }
    ]
}];

export default FRONT_ROUTES;