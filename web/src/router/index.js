import Video from "@/components/Video.vue";
import UserProfile from "@/components/user/UserProfile.vue";
import VueRouter from "vue-router";

export default new VueRouter({
  routes: [
    {
      path: "/recommend",
      component: Video,
    },
    {
      path: "/user",
      component: UserProfile,
    },
  ],
});
