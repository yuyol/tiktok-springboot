<template>
  <el-container>
    <!-- background z-index: 0-->
    <div class="test_bg"></div>
    <div class="dark_bg_2"></div>
    <el-header>
      <el-menu
        lang="scss"
        style="text-align: center; border: 0px; height: 60px"
        :default-active="activeIndex"
        class="el-menu-demo"
        mode="horizontal"
        @select="handleSelect"
      >
        <el-row :gutter="20">
          <el-col :span="5">
            <div class="icon"></div>
          </el-col>
          <el-col :span="13" :offset="3">
            <IndexInput></IndexInput>
          </el-col>

          <el-col :span="3">
            <div style="margin-top: 12px; text-align: left">
              <button
                class="loginRegister"
                :style="loginStyle"
                @click="showLoginDialog"
              ></button>

              <loginDialog></loginDialog>
              <registerDialog></registerDialog>

              <el-submenu index="2" class="profileIcon" :style="iconStlye">
                <IndexIconMenu></IndexIconMenu>
              </el-submenu>
            </div>
          </el-col>
        </el-row>
      </el-menu>
    </el-header>

    <div>
      <!-- <div class="dark_bg"></div> -->

      <el-container
        style="position: fixed; z-index: 1; width: 90%; height: 90%"
      >
        <el-aside width="80px">
          <!-- Aside menu -->
          <AsideMenu></AsideMenu>
        </el-aside>
        <el-main style="color: aliceblue">
          <router-view></router-view>
        </el-main>
      </el-container>
    </div>
  </el-container>
</template>

<script>
import IndexInput from "@/components/IndexInput.vue";
import IndexIconMenu from "@/components/IndexIconMenu.vue";
import AsideMenu from "@/components/AsideMenu.vue";
// import Video from "@/components/Video.vue";
import Swiper from "@/components/Swiper.vue";
import loginDialog from "@/components/auth/loginDialog.vue";
import registerDialog from "./auth/registerDialog.vue";
export default {
  data() {
    return {
      activeIndex: "1",
      activeIndex2: "1",
      restaurants: [],
      state1: "",
      state2: "",
      loginStyle: {
        display: "block",
      },
      iconStlye: {
        display: "none",
      },
      user: localStorage.getItem("user")
        ? JSON.parse(localStorage.getItem("user"))
        : {},
    };
  },
  components: {
    IndexInput,
    IndexIconMenu,
    AsideMenu,
    // Video,
    Swiper,
    loginDialog,
    registerDialog,
  },
  methods: {
    handleSelect(key, keyPath) {
      console.log(key, keyPath);
    },
    checkIfLogin() {
      // 登陆了则显示icon
      if (localStorage.getItem("user") != null) {
        this.iconStlye.display = "block";
        this.loginStyle.display = "none";
      } else {
        this.iconStlye.display = "none";
        this.loginStyle.display = "block";
      }
    },
    showLoginDialog() {
      console.log("test");
      this.dialogFormVisible = true;
      this.$bus.$emit("showLogin", true);
    },
  },
  mounted() {
    this.checkIfLogin();
  },
};
</script>

<style>
.el-header {
  /* background: url("../assets/background/dark_bg2.png"); */
  background-size: cover;
  background-color: transparent;
  color: #333;
  text-align: center;
  line-height: 58px;
  border: 0px;
}

.el-aside {
  background-color: transparent;
  text-align: center;
  line-height: 200px;
  margin-top: 20px;
}

.el-main {
  /* background-color: rgba(22, 24, 35); */
  background-color: transparent;
  color: #333;
  text-align: center;
  line-height: 20px;
}

.el-menu-demo,
.el-menu--horizontal,
.el-menu {
  background-color: transparent !important;
  border: 0px !important;
}

.el-submenu__title:hover {
  background: transparent !important;
}
.el-submenu__icon-arrow {
  color: transparent !important;
}

.test_bg {
  background-image: url("../assets/background/test.png");
  background-size: cover;
  width: 499px;
  height: 201px;
  z-index: 0;
  position: fixed;
}

.dark_bg {
  background-image: url("../assets/background/dark_bg3.png");
  background-size: cover;
  width: 100%;
  height: 44px;
  z-index: -1;
  position: fixed;
}

.dark_bg_2 {
  position: fixed;
  width: 100%;
  height: 100%;
  z-index: -1;
  /* margin-top: 44px; */
  background-color: rgba(22, 24, 35);
}

.icon {
  background-image: url("../assets/background/icon-white.png");
  background-size: cover;
  width: 33px;
  height: 40px;
  margin-top: 12px;
  margin-left: 5px;
}

.profileIcon {
  width: 36px !important;
  height: 36px !important;
  background: white;
  border-radius: 50%;
  background-image: url("../assets/profilePic/profile1.jpg");
  background-size: cover;
}

.loginRegister {
  width: 36px !important;
  height: 36px !important;
  background: white;
  border-radius: 50%;
  /* background-image: url("../assets/profilePic/profile1.jpg");
  background-size: cover; */
  border: 0px;
  cursor: pointer;
}
</style>
