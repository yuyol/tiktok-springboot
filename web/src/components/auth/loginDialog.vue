<template scoped>
  <div>
    <el-dialog width="400px" title="登录" :visible.sync="dialogFormVisible">
      <el-form :model="form">
        <el-form-item label="手机号" :label-width="auto">
          <el-input
            v-model="loginInfo.mobileNumber"
            autocomplete="off"
          ></el-input>
        </el-form-item>
        <el-form-item label="密码" :label-width="auto">
          <el-input v-model="loginInfo.password" show-password></el-input>
        </el-form-item>
        <span style="color: red">{{ loginErrorMsg }}</span>
      </el-form>
      <el-button @click="toRegister">还没有账号？去注册</el-button>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="login">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
export default {
  data() {
    return {
      dialogFormVisible: false,
      loginInfo: {
        mobileNumber: "",
        password: "",
      },
      formLabelWidth: "120px",
      loginErrorMsg: "",
    };
  },
  methods: {
    login() {
      // 1. 向后端发送请求查找是否有用户
      // 1.1 有则将token存入，并刷新页面
      // 1。2 无则提示账号密码错误
      this.$http
        .post("http://localhost:8081/login", this.loginInfo)
        .then((res) => {
          console.log("success");
          localStorage.setItem("user", JSON.stringify(res));
          this.dialogFormVisible = false;
          this.loginErrorMsg = "";
          location.reload();
        })
        .catch((error) => {
          console.log("failed");
          console.log(error);
          this.loginErrorMsg = error.response.data.errorMessage;
        });
      // sessionStorage.setItem("token", "12345");
    },
    toRegister() {
      this.$bus.$emit("showRegister", true);
      this.dialogFormVisible = false;
    },
  },
  mounted() {
    this.$bus.$on("showLogin", (data) => {
      console.log(data);
      this.dialogFormVisible = data;
    });
  },
  beforeDestroy() {
    this.$bus.$off("showLogin");
  },
};
</script>

<style scoped>
.el-input {
  background: rgb(243, 247, 255) !important;
}
</style>
