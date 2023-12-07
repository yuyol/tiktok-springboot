<template>
  <el-menu :default-openeds="['1', '3']">
    <el-menu-item>首页</el-menu-item>
    <el-menu-item>推荐</el-menu-item>
    <el-menu-item>商城</el-menu-item>
    <el-menu-item>关注</el-menu-item>
    <el-menu-item>朋友</el-menu-item>
    <el-menu-item>我的</el-menu-item>
  </el-menu>
</template>

<style>
.el-menu-item {
  color: white !important;
}

.el-menu-item:hover {
  background: black !important;
}
</style>
