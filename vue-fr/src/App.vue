<script setup lang="ts">
import Navbar from "./components/Navbar.vue";
import LoginForm from "./components/LoginForm.vue"
import {ref} from 'vue';


const showLoginForm = ref(false);

const toggleLoginForm = () => {
	showLoginForm.value = !showLoginForm.value;
}
</script>

<template>
	<Navbar @toggleLogin="toggleLoginForm"/>
	<LoginForm v-if="showLoginForm" @close="toggleLoginForm" @submit=""/>
	<RouterView />
</template>

<style scoped></style>
