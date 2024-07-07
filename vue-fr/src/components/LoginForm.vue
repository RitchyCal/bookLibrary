<script lang="ts">
import BaseForm from "./BaseForm.vue";

export default {
	components: {
		BaseForm,
	},

	data() {
		return {
			showLogin: true,
			username: "",
			password: "",
			email: "",
			signupPassword: "",
		};
	},
	methods: {
		toggleForm() {
			this.showLogin = !this.showLogin;
		},
		handleSubmit() {
			console.log("Username", this.username);
			console.log("Password", this.password);
		},
		closeLoginForm() {
			this.username = "";
			this.password = "";
		},
		login() {
			console.log("login");
			this.$emit('close');
		},
		signup(){
			console.log("signup");
			this.$emit('close');
		}
	},
};
</script>

<template>
	<BaseForm
		v-if="showLogin"
		title="Login"
		@close="closeLoginForm"
		@submit="handleSubmit"
	>
		<template #form-fields>
			<div>
				<label for="username" class="block text-sm font-medium text-gray-700"
					>Username</label
				>
				<input
					type="text"
					id="username"
					v-model="username"
					class="mt-1 block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm"
				/>
			</div>
			<div>
				<label for="password" class="block text-sm font-medium text-gray-700"
					>Password</label
				>
				<input
					type="password"
					id="password"
					v-model="password"
					class="mt-1 block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm"
				/>
			</div>
		</template>
		<template #form-buttons>
			<button
				type="submit"
				class="bg-blue-500 text-white py-2 px-4 rounded-md shadow-sm hover:bg-blue-600 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500 mb-2"
				@click="toggleForm"
			>
				Login
			</button>
			<button
				type="button"
				class="bg-green-500 text-white py-2 px-4 rounded-md shadow-sm hover:bg-green-600 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500"
				@click="toggleForm"
			>
				Sign Up
			</button>
		</template>
	</BaseForm>

	<BaseForm v-else title="Signup" @close="$emit('close')">
		<template #form-fields>
			<div>
				<label for="username" class="block text-sm font-medium text-gray-700"
					>Username</label
				>
				<input
					type="text"
					id="username"
					v-model="username"
					class="mt-1 block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm"
				/>
			</div>
			<div>
				<label for="email" class="block text-sm font-medium text-gray-700"
					>Email</label
				>
				<input
					type="email"
					id="email"
					v-model="email"
					class="mt-1 block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm"
				/>
			</div>
			<div>
				<label for="password" class="block text-sm font-medium text-gray-700"
					>Password</label
				>
				<input
					type="password"
					id="password"
					v-model="password"
					class="mt-1 block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm"
				/>
			</div>
		</template>
		<template #form-buttons>
			<button
				type="submit"
				class="bg-green-500 text-white py-2 px-4 rounded-md shadow-sm hover:bg-green-600 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500 mb-2"
				@click="$emit('close')"
			>
				Sign Up
			</button>
				<button
					type="button"
					class="bg-gray-500 text-white py-2 px-4 rounded-md shadow-sm hover:bg-gray-600 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500"
					@click="toggleForm"
				>
					Back to Login
				</button>
		</template>
	</BaseForm>
</template>
