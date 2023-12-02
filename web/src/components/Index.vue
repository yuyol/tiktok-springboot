<template>
  <el-container style="height: 500px; border: 1px solid #eee">
    <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
      <el-menu :default-openeds="['1', '3']">
        <el-menu-item>首页</el-menu-item>
        <el-menu-item>推荐</el-menu-item>
        <el-menu-item>关注</el-menu-item>
        <el-menu-item>朋友</el-menu-item>
        <el-menu-item>我的</el-menu-item>
<!--        <el-submenu index="2">-->
<!--          <template slot="title"><i class="el-icon-menu"></i>导航二</template>-->
<!--          <el-menu-item-group>-->
<!--            <template slot="title">分组一</template>-->
<!--            <el-menu-item index="2-1">选项1</el-menu-item>-->
<!--            <el-menu-item index="2-2">选项2</el-menu-item>-->
<!--          </el-menu-item-group>-->
<!--          <el-menu-item-group title="分组2">-->
<!--            <el-menu-item index="2-3">选项3</el-menu-item>-->
<!--          </el-menu-item-group>-->
<!--          <el-submenu index="2-4">-->
<!--            <template slot="title">选项4</template>-->
<!--            <el-menu-item index="2-4-1">选项4-1</el-menu-item>-->
<!--          </el-submenu>-->
<!--        </el-submenu>-->
<!--        <el-submenu index="3">-->
<!--          <template slot="title"><i class="el-icon-setting"></i>导航三</template>-->
<!--          <el-menu-item-group>-->
<!--            <template slot="title">分组一</template>-->
<!--            <el-menu-item index="3-1">选项1</el-menu-item>-->
<!--            <el-menu-item index="3-2">选项2</el-menu-item>-->
<!--          </el-menu-item-group>-->
<!--          <el-menu-item-group title="分组2">-->
<!--            <el-menu-item index="3-3">选项3</el-menu-item>-->
<!--          </el-menu-item-group>-->
<!--          <el-submenu index="3-4">-->
<!--            <template slot="title">选项4</template>-->
<!--            <el-menu-item index="3-4-1">选项4-1</el-menu-item>-->
<!--          </el-submenu>-->
<!--        </el-submenu>-->
      </el-menu>
    </el-aside>

    <el-container>
      <el-header style="text-align: left; font-size: 12px; background: white">


        <el-menu style="text-align: center" :default-active="activeIndex" class="el-menu-demo" mode="horizontal" @select="handleSelect">
          <el-row :gutter="20">
            <el-col :span="10" style="text-align: left">
              <div>TikTok</div>
            </el-col>

            <el-col :span="11" style="text-align: left">
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