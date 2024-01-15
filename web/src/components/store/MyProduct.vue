<template>
  <div style="display: flex; position: relative">
    <div class="merchantsContainer">
      My Product
      <el-row
        type="flex"
        :gutter="0"
        :span="25"
        v-for="merchants in merchantInfo"
        :key="merchants.id"
        style="min-width: 1000px"
      >
        <el-col
          :span="5"
          v-for="merchant in merchants.childrens"
          :key="merchant.id"
        >
          <router-link
            :to="`/merchantDetails?id=${merchant.id}&title=${merchant.name}`"
            class="routerLink"
          >
            <div class="merchantFrame">
              <div class="thumbnail"></div>
              <div class="textFrame">
                <div>价格：{{ merchant.price }}</div>
                <div>{{ merchant.name }}</div>
                <div>{{ merchant.description }}</div>
              </div>
            </div>
          </router-link>
        </el-col>
      </el-row>
    </div>
  </div>
</template>

<style scoped>
.routerLink {
  text-decoration: none !important;
}
.merchantsContainer {
  width: 1000px;
  flex-direction: column;
  margin: 0 auto;
}
.merchantFrame {
  width: 200px;
  height: 270px;
  background: white;
  color: black;
  border: black 1px solid;
  margin: 10px;
  text-align: left;
  border-radius: 15px;
}
.thumbnail {
  width: 180px;
  height: 180px;
  background: black;
  margin-left: 10px;
  margin-top: 10px;
  margin-bottom: 10px;
  border-radius: 15px;
}
.textFrame {
  margin-left: 10px;
}
/* .el-row {
    margin-bottom: 20px;
  }
  .el-col {
    border-radius: 4px;
  }
  .bg-purple-dark {
    background: #99a9bf;
  }
  .bg-purple {
    background: #d3dce6;
  }
  .bg-purple-light {
    background: #e5e9f2;
  }
  .grid-content {
    border-radius: 4px;
    min-height: 36px;
  }
  .row-bg {
    padding: 10px 0;
    background-color: #f9fafc;
  } */
</style>
<script>
export default {
  data() {
    return {
      userId: 0,
      merchantInfo: [],
    };
  },
  methods: {
    findProductList() {
      console.log(this.userId);
      this.$http
        .get("http://localhost:8101/getProductListBySeller", {
          params: {
            userId: this.userId,
          },
        })
        .then((res) => {
          console.log(res);
          this.merchantInfo = res.data;
          console.log(this.merchantInfo);
        })
        .catch((error) => {
          console.error(error);
        });
    },
  },
  mounted() {
    this.userId = JSON.parse(localStorage.getItem("user")).data.userId;
    this.findProductList();
  },
};
</script>
