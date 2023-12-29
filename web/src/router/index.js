import Video from "@/components/Video.vue";
import UserProfile from "@/components/user/UserProfile.vue";
import VueRouter from "vue-router";
import Works from "@/components/user/Works.vue";
import Likes from "@/components/user/Likes.vue";
import Collection from "@/components/user/Collection.vue";
import History from "@/components/user/History.vue";
import Creation from "@/components/user/Creation.vue";

export default new VueRouter({
  routes: [
    {
      path: "/recommend",
      name: "recommend",
      component: Video,
    },
    {
      path: "/user",
      name: "user",
      component: UserProfile,
      children: [
        {
          path: "works",
          component: Works,
        },
        {
          path: "likes",
          component: Likes,
        },
        {
          path: "collection",
          component: Collection,
        },
        {
          path: "history",
          component: History,
        },
        {
          path: "creation",
          component: Creation,
        },
      ],
    },
  ],
});
