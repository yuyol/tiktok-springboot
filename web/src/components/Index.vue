<template>
  <el-container style="height: 800px; border: 1px solid #eee; margin-top: -40px">

    <el-aside width="80px" style="background-color: rgb(238, 241, 246);">
      <div style="margin-top:21px; margin-bottom: 21px">TIKTOK</div>
      <el-menu :default-openeds="['1', '3']">
        <el-menu-item>首页</el-menu-item>
        <el-menu-item>推荐</el-menu-item>
        <el-menu-item>商城</el-menu-item>
        <el-menu-item>关注</el-menu-item>
        <el-menu-item>朋友</el-menu-item>
        <el-menu-item>我的</el-menu-item>

      </el-menu>
    </el-aside>

    <el-container>
      <el-header style="text-align: left; font-size: 12px; background: rgb(238, 241, 246)">


        <el-menu style="text-align: center; background: rgb(238, 241, 246); border: 0px" :default-active="activeIndex" class="el-menu-demo" mode="horizontal" @select="handleSelect">
          <el-row :gutter="20">
<!--            <el-col :span="10" style="text-align: left">-->
<!--              <div style="width: 100px">a</div>-->
<!--            </el-col>-->

            <el-col :span="13" :offset="8">
              <IndexInput></IndexInput>
            </el-col>


            <el-col :span="3">
              <el-submenu index="2">
                <template slot="title">icon</template>
                <div style="width:500px;height: 200px;">
                  <el-row style="text-align: center; margin-top: 10px">
                    <el-col :span="6"><el-button>主页</el-button></el-col>
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
<!--                <el-menu-item index="2-1">选项1</el-menu-item>-->
<!--                <el-menu-item index="2-2">选项2</el-menu-item>-->
<!--                <el-menu-item index="2-3">选项3</el-menu-item>-->
<!--                <el-submenu index="2-4">-->
<!--                  <template slot="title">选项4</template>-->
<!--                  <el-menu-item index="2-4-1">选项1</el-menu-item>-->
<!--                  <el-menu-item index="2-4-2">选项2</el-menu-item>-->
<!--                  <el-menu-item index="2-4-3">选项3</el-menu-item>-->
<!--                </el-submenu>-->
              </el-submenu>
            </el-col>
          </el-row>
        </el-menu>
      </el-header>

      <el-main>
        <h1>Video</h1>
      </el-main>

    </el-container>
  </el-container>
</template>


<style>
.el-header {
  background-color: #B3C0D1;
  color: #333;
  line-height: 60px;
}

.el-aside {
  color: #333;
}

.el-menu-demo{
  background: #42b983;
}

.icon{

}
.icon:hover + .iconNav{
  display: block;
  opacity: 1;
  transition: opacity 2s;
}

.iconNav{
  opacity: 0;
  display: none;
  width: 500px;
  height: 100px;
  background: #2c3e50;
}

</style>

<script>
import IndexInput from "@/components/IndexInput.vue";
export default {

  data() {

    return {
      tableData: Array(20).fill(item),
      activeIndex: '1',
      activeIndex2: '1',
      restaurants: [],
      state1: '',
      state2: ''
    }
  },
  components: {
    IndexInput
  },
  methods: {
    handleSelect(key, keyPath) {
      console.log(key, keyPath);
    },
  }
};
</script>