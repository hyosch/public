import { createRouter, createWebHistory } from "vue-router";
import Query from "../components/QueryPage.vue";
import Add from "../components/AddPage.vue";

export const routes = createRouter({
  history: createWebHistory(),
  routes: [
    {
      path: "/",
      name: "Query",
      component: Query,
    },
    {
      path: "/add",
      name: "Add",
      component: Add,
    },
  ],
});
