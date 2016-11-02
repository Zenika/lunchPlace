const ADMIN_ROUTES = [{
    path: '/admin',
    component: require('./Admin'),
    children: [
        { name: 'admin.list',  path: '', component: require('./RestaurantsList') },
        { name: 'admin.edit', path: 'edit', component: require('./RestaurantForm') },
        { path: '*', component: require('./RestaurantsList') }
    ]
}];

export default ADMIN_ROUTES;