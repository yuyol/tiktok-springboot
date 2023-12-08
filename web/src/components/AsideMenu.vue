<template>
  <el-menu :default-openeds="['1', '3']">
    <el-menu-item style="padding-top: 10px">
      <div class="index"></div>
      <div style="margin-top: -20px">首页</div>
    </el-menu-item>
    <el-menu-item style="padding-top: 10px">
      <div class="recommend"></div>
      <div style="margin-top: -20px">推荐</div>
    </el-menu-item>
    <el-menu-item style="padding-top: 10px">
      <div class="shopping"></div>
      <div style="margin-top: -20px">商城</div>
    </el-menu-item>
    <el-menu-item style="padding-top: 10px">
      <div class="follow"></div>
      <div style="margin-top: -20px">关注</div>
    </el-menu-item>
    <el-menu-item style="padding-top: 10px">
      <div class="friends"></div>
      <div style="margin-top: -20px">朋友</div>
    </el-menu-item>
    <el-menu-item style="padding-top: 10px">
      <div class="my"></div>
      <div style="margin-top: -20px">我的</div>
    </el-menu-item>
  </el-menu>
</template>

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
</style>
