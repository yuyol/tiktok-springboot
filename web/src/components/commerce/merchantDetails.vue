<template>
  <div>
    <div class="container">
      <div class="imgFrame">
        <div class="imgBooth"></div>
        <div class="thumb">
          <button
            v-for="item in typeList"
            :key="item.id"
            class="thumbItem"
            @click="buttonClickGetDetails(item.productInfoId)"
          >
            {{ item.type }}
          </button>
        </div>
      </div>
      <div class="textFrame">
        <div style="font-size: 18px">商品名称：{{ productName }}</div>
        <div style="margin-top: 25px">价格: {{ price }} ￥</div>
        <div style="margin-top: 25px">描述: {{ description }}</div>
        <div style="margin-top: 25px">尺码: {{ type }}</div>
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
  color: white;
  border: 0px;
  cursor: pointer;
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
      userId: 0,
      productInfoId: 0,
      productName: "",
      price: 0,
      description: "",
      type: "",
      detailInfo: {},
      typeList: {},
    };
  },
  methods: {
    getDetails() {
      console.log(this.userId);
      console.log(this.productInfoId);
      this.$http
        .get("http://localhost:8101/getProductDetails", {
          params: {
            userId: this.userId,
            productInfoId: this.productInfoId,
            productName: this.productName,
          },
        })
        .then((res) => {
          this.detailInfo = res.data;
          this.typeList = this.detailInfo.productType;
          this.productName = this.detailInfo.name;
          this.price = this.detailInfo.price;
          this.description = this.detailInfo.description;
          this.productInfoId = this.detailInfo.productInfoId;
          this.type = this.detailInfo.type;
          console.log(this.detailInfo);
        });
    },
    buttonClickGetDetails(productInfoId) {
      this.productInfoId = productInfoId;
      this.getDetails();
    },
  },
  mounted() {
    this.query = this.$route.query;
    this.userId = this.query.id;
    this.productInfoId = this.query.productInfoId;
    this.productName = this.query.productName;
    // this.price = this.query.price;
    this.getDetails();
  },
};
</script>
