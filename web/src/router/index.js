import Video from "@/components/Video.vue";
import VueRouter from "vue-router";

export default new VueRouter({
  routes: [
    {
      path: "/recommend",
      component: Video,
    },
  ],
});
