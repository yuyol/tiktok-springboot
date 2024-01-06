<template>
  <div>
    <div class="user-bottom-content-frame">
      <div class="user-tabbar">
        <div class="user-tabbar-inner">
          <div class="user-tabber-inner-left">
            <router-link
              v-for="(item, index) in storeTabBarList"
              :key="index"
              :to="item.name"
              class="router_link_style"
            >
              <div class="user-works">
                <button class="user-tabbar-button">{{ item.navItem }}</button>
              </div></router-link
            >
          </div>
        </div>
      </div>
    </div>
    <router-view></router-view>
  </div>
</template>

<script>
export default {
  name: "MyStore",
  data() {
    return {
      storeTabBarList: [
        { name: "/user/myStore/uploadProduct", navItem: "上架商品" },
        { name: "/user/myStore/myProduct", navItem: "我的商品" },
      ],
    };
  },
};
</script>

<style scoped>
.router_link_style {
  text-decoration: none;
}
.user-tabbar-button {
  font-size: 18px;
  background: transparent;
  border: 0px;
  color: white;
  cursor: pointer;
}
.user-works {
  align-items: center;
  cursor: pointer;
  display: flex;
  margin-right: 40px;
}
.user-tabber-inner-left {
  display: flex;
  height: 26px;
}
.user-tabbar-inner {
  align-items: center;
  display: flex;
  height: 36px;
  justify-content: space-between;
  margin: 11px 0;
  position: relative;
  width: 100%;
  min-width: 1000px;
}
.user-tabbar {
  border-top: 1px solid rgb(255, 255, 255, 0.1);
  padding: 0;
}
.user-bottom-content-frame {
  margin: 0 auto;
  margin-top: 0px;
  margin-right: 30px;
  margin-bottom: 0px;
  margin-left: 30px;
}
</style>
