import { createRouter, createWebHistory } from "vue-router";
import LoginForm from '../components/LoginForm.vue';
import SignupForm from '../components/SignupForm.vue';
import HomeView from "../views/HomeView.vue";

const routes = [
		{
			path: "/",
			name: "Home",
			component: HomeView,
			alias: "/Home",
		},
		{
			path: "/login",
			name: "Login",
			component: LoginForm,
		},
		{
			path: "/signup",
			name: "Signup",
			component: SignupForm,
		},
	];
const router = createRouter({
	history: createWebHistory(),
	routes,
});

export default router;
