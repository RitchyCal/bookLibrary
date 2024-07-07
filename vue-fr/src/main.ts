import { createApp } from "vue";
import App from "./App.vue";
import router from "./router/router";
import "./index.css";
import "./style.css";
import "../node_modules/flowbite-vue/dist/index.css";

const app = createApp(App)
app.use(router);
app.mount("#app");
