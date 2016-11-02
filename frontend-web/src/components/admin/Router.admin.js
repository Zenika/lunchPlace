const ADMIN_ROUTES = [{
    path: '/admin',
    component: require('./Admin'),
    children: [
        { path: '', component: require('./RestaurantsList') },
        { path: 'edit', component: require('./RestaurantForm') },
        { path: '*', component: require('./RestaurantsList') }
    ]
}];

export default ADMIN_ROUTES;