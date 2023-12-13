<template>
  <div style="width: 500px; height: 200px; background-color: #20202b">
    <el-row style="text-align: center; margin-top: 10px">
      <el-col :span="6">
        <router-link
          v-for="(item, index) in navList"
          :key="index"
          :to="item.name"
          class="router_link_style"
        >
          <el-button :index="item.name">
            {{ item.navItem }}
          </el-button></router-link
        ></el-col
      >
    </el-row>
    <el-row style="text-align: center; margin-top: 30px">
      <el-col :span="6"><el-button>我的作品</el-button></el-col>
      <el-col :span="6"><el-button>我的喜欢</el-button></el-col>
      <el-col :span="6"><el-button>我的收藏</el-button></el-col>
      <el-col :span="6"><el-button>观看历史</el-button></el-col>
    </el-row>

    <el-row style="text-align: center; margin-top: 30px">
      <el-col :span="6"><el-button>我的订单</el-button></el-col>
      <el-col :span="6"><el-button>退出登录</el-button></el-col>
      <el-col :span="6"><el-button>设置</el-button></el-col>
    </el-row>
  </div>
</template>

<script>
export default {
  name: "IndexIconMenu",
  data() {
    return {
      navList: [{ name: "/user", navItem: "主页", navClass: "UserProfile" }],
    };
  },
};
</script>

<style>
.router_link_style {
  color: black;
  text-decoration: none;
}
</style>
