<template>
  <div>
    <div class="container">
      <div class="imgFrame">
        <div class="imgBooth"></div>
        <div class="thumb">
          <div class="thumbItem">1</div>
          <div class="thumbItem">2</div>
          <div class="thumbItem">3</div>
        </div>
      </div>
      <div>id: {{ query.id }}</div>
      <div>商品名称：{{ query.title }}</div>
      <div>价格:</div>
      <div>描述:</div>
    </div>
  </div>
</template>

<style scoped>
.container {
  width: 1000px;
  margin: 0 auto;
  text-align: left;
  display: flex;
}
.imgFrame {
  /* display: flex; */
  width: 400px;
  background: white;
}
.imgBooth {
  width: 400px;
  height: 400px;
  background: grey;
  margin-bottom: 15px;
}
.thumb {
  display: flex;
}
.thumbItem {
  width: 50px;
  height: 50px;
  background: black;
  margin-right: 10px;
}
</style>

<script>
export default {
  name: "merchantDetails",
  data() {
    return {
      query: {},
    };
  },
  mounted() {
    // console.log(this.$route);
    this.query = this.$route.query;
    console.log(this.query);
  },
};
</script>
