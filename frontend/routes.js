import Home from './src/views/Home.vue';
import ItemDetail from './src/views/ItemDetail.vue';
import Login from './src/views/Login.vue';
import Logout from './src/views/Logout.vue';
import AdminDetail from './src/views/AdminDetail.vue';
import SellerDetail from './src/views/SellerDetail.vue';
import BuyerDetail from './src/views/BuyerDetail.vue';
import Registration from  "./src/views/Registration.vue";
import CategoryDetail from  "./src/views/CategoryDetail.vue";
import CategoryList from  "./src/views/CategoryList.vue";
import UserDetail from "./src/views/UserDetail.vue";
import Profile from "./src/views/Profile.vue";
import UserList from "./src/views/UserList.vue";

const routes = [
    { path: '/', component: Home },
    { path: '/login', component: Login },
    { path: '/logout', component: Logout },
    { path: '/registration', component: Registration },
    { path: '/items/:id', component: ItemDetail, props: true},
    { path: '/buyer', component: BuyerDetail},
    { path: '/seller', component: SellerDetail},
    { path: '/categories/:category', component: CategoryDetail, props: true},
    { path: '/admin', component: AdminDetail},
    { path: '/categoryList', component: CategoryList},
    { path: '/profile', component: Profile},
    { path: '/users/:id', component: UserDetail, props: true},
    { path: '/users/', component: UserList},
];


export default routes;
