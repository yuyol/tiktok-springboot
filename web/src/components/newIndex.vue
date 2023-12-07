<template>
  <el-container>
    <el-header>
      <el-menu
        lang="scss"
        style="
          text-align: center;
          /* background: rgb(238, 241, 246); */
          /* background-color: transparent; */
          border: 0px;
          height: 60px;
        "
        :default-active="activeIndex"
        class="el-menu-demo"
        mode="horizontal"
        @select="handleSelect"
      >
        <el-row :gutter="20">
          <el-col :span="13" :offset="8">
            <IndexInput></IndexInput>
          </el-col>

          <el-col :span="3">
            <el-submenu index="2">
              <template slot="title">icon</template>
              <!-- Icon menu -->
              <IndexIconMenu></IndexIconMenu>
            </el-submenu>
          </el-col>
        </el-row>
      </el-menu>
    </el-header>

    <div>
      <div class="dark_bg"></div>
      <div class="dark_bg_2"></div>

      <el-container style="position: fixed; z-index: 1; width: 100%">
        <el-aside width="80px">
          <!-- Aside menu -->
          <AsideMenu></AsideMenu>
        </el-aside>
        <el-main style="color: aliceblue">Video</el-main>
      </el-container>
    </div>
  </el-container>
</template>

<script>
import IndexInput from "@/components/IndexInput.vue";
import IndexIconMenu from "@/components/IndexIconMenu.vue";
import AsideMenu from "@/components/AsideMenu.vue";
export default {
  data() {
    return {
      activeIndex: "1",
      activeIndex2: "1",
      restaurants: [],
      state1: "",
      state2: "",
    };
  },
  components: {
    IndexInput,
    IndexIconMenu,
    AsideMenu,
  },
  methods: {
    handleSelect(key, keyPath) {
      console.log(key, keyPath);
    },
  },
};
</script>

<style>
.el-header {
  /* background-color: #b3c0d1; */
  background: url("../assets/background/dark_bg2.png");
  background-size: cover;
  background-color: transparent;
  color: #333;
  text-align: center;
  line-height: 58px;
  border: 0px;
}

.el-aside {
  /* background-color: #d3dce6; */
  background-color: transparent;
  text-align: center;
  line-height: 200px;
}

.el-main {
  /* background-color: #e9eef3; */
  /* background-color: rgba(22, 24, 35); */
  background-color: transparent;
  color: #333;
  text-align: center;
  line-height: 160px;
}

.el-menu-demo,
.el-menu--horizontal,
.el-menu {
  background-color: transparent !important;
  border: 0px !important;
}

.dark_bg {
  background-image: url("../assets/background/dark_bg3.png");
  background-size: cover;
  width: 100%;
  height: 44px;
  z-index: 1;
  position: fixed;
}

.dark_bg_2 {
  position: fixed;
  width: 100%;
  height: 100%;
  z-index: 0;
  margin-top: 44px;
  background-color: rgba(22, 24, 35);
}

/* body > .el-container {
  margin-bottom: 40px;
}

.el-container:nth-child(5) .el-aside,
.el-container:nth-child(6) .el-aside {
  line-height: 260px;
}

.el-container:nth-child(7) .el-aside {
  line-height: 320px;
} */
</style>
