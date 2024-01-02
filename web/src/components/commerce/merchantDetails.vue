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
      <div class="textFrame">
        <div style="font-size: 18px">商品名称：{{ merchantInfo.title }}</div>
        <div style="margin-top: 25px">价格: {{ merchantInfo.price }} ￥</div>
        <div>描述:</div>
      </div>
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
  /* background: white; */
  background: transparent;
}
.imgBooth {
  width: 400px;
  height: 400px;
  background: grey;
  margin-bottom: 15px;
  border-radius: 15px;
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
.textFrame {
  margin-left: 20px;
}
</style>

<script>
export default {
  name: "merchantDetails",
  data() {
    return {
      query: {},
      merchantInfo: {
        title: "过年新年战袍红色短款羽绒服外套女款2023年新款时尚洋气女装冬季",
        price: 328,
      },
    };
  },
  mounted() {
    // console.log(this.$route);
    this.query = this.$route.query;
    console.log(this.query);
  },
};
</script>
