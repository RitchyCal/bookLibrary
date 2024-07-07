<script setup lang="ts">
import {
	FwbButton,
	FwbNavbar,
	FwbNavbarCollapse,
	FwbNavbarLink,
	FwbNavbarLogo,
} from "flowbite-vue";

import { RouterLink } from "vue-router";
</script>

<template>
	<fwb-navbar>
		<template #logo>
			<RouterLink to="/Home">
				<fwb-navbar-logo alt="" img src="src\assets\vue.svg" link="#">
					Library
				</fwb-navbar-logo>
			</RouterLink>
		</template>
		<template #default="{ isShowMenu }">
			<fwb-navbar-collapse :is-show-menu="isShowMenu">
				<fwb-navbar-link is-active link="#"
					><RouterLink to="/">Home</RouterLink></fwb-navbar-link
				>
				<fwb-navbar-link link="#"> Services </fwb-navbar-link>
				<fwb-navbar-link link="#"> Pricing </fwb-navbar-link>
				<fwb-navbar-link link="#"> Contact </fwb-navbar-link>
			</fwb-navbar-collapse>
		</template>
		<template #right-side>
			<fwb-button @click="$emit('toggleLogin')">Login</fwb-button>
		</template>
	</fwb-navbar>
</template>
