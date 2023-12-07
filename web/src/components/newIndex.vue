<template>
  <el-container>
    <el-header>
      <el-menu
        style="
          text-align: center;
          background: rgb(238, 241, 246);
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

    <el-container>
      <el-aside width="80px">
        <!-- Aside menu -->
        <AsideMenu></AsideMenu>
      </el-aside>
      <el-main>Video</el-main>
    </el-container>
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
  background-color: #b3c0d1;
  /* background-color: transparent; */
  color: #333;
  text-align: center;
  line-height: 60px;
}

.el-aside {
  background-color: #d3dce6;
  color: #333;
  text-align: center;
  line-height: 200px;
}

.el-main {
  background-color: #e9eef3;
  color: #333;
  text-align: center;
  line-height: 160px;
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
