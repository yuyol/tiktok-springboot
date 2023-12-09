<template>
  <el-menu :default-openeds="['1', '3']">
    <el-menu-item
      v-for="(item, index) in navList"
      :key="index"
      :index="item.name"
      style="padding-top: 10px"
    >
      <div :class="item.navClass"></div>
      <div style="margin-top: -20px">{{ item.navItem }}</div>
    </el-menu-item>
  </el-menu>
</template>

<script>
export default {
  name: "AsideMenu",
  data() {
    return {
      activeIndex: "/index",
      navList: [
        { name: "/index", navItem: "首页", navClass: "index" },
        { name: "/recommend", navItem: "推荐", navClass: "recommend" },
        { name: "/shopping", navItem: "商城", navClass: "shopping" },
        { name: "/follow", navItem: "关注", navClass: "follow" },
        { name: "/friends", navItem: "朋友", navClass: "friends" },
        { name: "/my", navItem: "我的", navClass: "my" },
      ],
    };
  },
};
</script>

<style>
.index {
  background-image: url("../assets/background/nav/0index.png");
  background-size: cover;
  width: 22px;
  height: 22px;
  text-align: center !important;
  margin-left: 19px;
}
.recommend {
  background-image: url("../assets/background/nav/144recommend.png");
  background-size: cover;
  width: 22px;
  height: 22px;
  text-align: center !important;
  margin-left: 19px;
}
.shopping {
  background-image: url("../assets/background/nav/1872shopping.png");
  background-size: cover;
  width: 22px;
  height: 22px;
  text-align: center !important;
  margin-left: 19px;
}
.follow {
  background-image: url("../assets/background/nav/288follow.png");
  background-size: cover;
  width: 22px;
  height: 22px;
  text-align: center !important;
  margin-left: 19px;
}
.friends {
  background-image: url("../assets/background/nav/432friend.png");
  background-size: cover;
  width: 22px;
  height: 22px;
  text-align: center !important;
  margin-left: 19px;
}
.my {
  background-image: url("../assets/background/nav/504my.png");
  background-size: cover;
  width: 22px;
  height: 22px;
  text-align: center !important;
  margin-left: 19px;
}

.el-menu {
  height: 100%;
}

.el-menu-item {
  color: white !important;
  padding-left: 0px !important;
  padding-right: 0px !important;
  text-align: center !important;
  height: 58px !important;
  width: 60px !important;
  border-radius: 10px !important;
  margin: 10px;
}

.el-menu-item:hover {
  background: rgb(255, 255, 255, 0.2) !important;
}

.el-menu-item:focus {
  background: rgb(255, 255, 255, 0.2) !important;
}
</style>
