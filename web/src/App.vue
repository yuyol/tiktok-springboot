<template>
  <div id="app" style="margin-top: 0px">
    <!-- <Index></Index> -->
    <newIndex></newIndex>
  </div>
</template>

<script>
import newIndex from "./components/newIndex.vue";

export default {
  name: "App",
  components: {
    newIndex,
  },
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
