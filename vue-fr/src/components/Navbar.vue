<script setup lang="ts">
import {
	FwbButton,
	FwbNavbar,
	FwbNavbarCollapse,
	FwbNavbarLink,
	FwbNavbarLogo,
} from "flowbite-vue";

import {ref} from "vue";

const isLoggedIn = ref(false);

const toggle = () => {
	isLoggedIn.value = !isLoggedIn.value;
};
</script>

<template>
	<fwb-navbar>
		<template #logo>
			<fwb-navbar-logo alt="" img src="src\assets\vue.svg" link="#">
				Library
			</fwb-navbar-logo>
		</template>
		<template #default="{ isShowMenu }">
			<fwb-navbar-collapse :is-show-menu="isShowMenu">
				<fwb-navbar-link is-active link="#"> Home </fwb-navbar-link>
				<fwb-navbar-link link="#"> Services </fwb-navbar-link>
				<fwb-navbar-link link="#"> Pricing </fwb-navbar-link>
				<fwb-navbar-link link="#"> Contact </fwb-navbar-link>
			</fwb-navbar-collapse>
		</template>
		<template #right-side>
			<fwb-button @click="toggle" v-if="isLoggedIn == true">Login</fwb-button>
			<fwb-button @click="toggle" v-if="isLoggedIn == false">Logout</fwb-button>
		</template>
	</fwb-navbar>
</template>
