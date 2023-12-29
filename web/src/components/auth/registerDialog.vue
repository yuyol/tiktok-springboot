<template scoped>
  <div>
    <el-dialog width="400px" title="注册" :visible.sync="dialogFormVisible">
      <el-form :model="form">
        <el-form-item label="昵称*" :label-width="auto">
          <el-input v-model="registerInfo.username"></el-input>
        </el-form-item>
        <el-form-item label="邮箱号" :label-width="auto">
          <el-input v-model="registerInfo.email"></el-input>
        </el-form-item>
        <el-form-item label="手机号*" :label-width="auto">
          <el-input v-model="registerInfo.mobileNumber"></el-input>
        </el-form-item>
        <el-form-item label="密码*" :label-width="auto">
          <el-input v-model="registerInfo.password" show-password></el-input>
        </el-form-item>
        <el-form-item label="再次输入密码*" :label-width="auto">
          <el-input
            v-model="registerInfo.reEnterPassword"
            show-password
          ></el-input>
        </el-form-item>
        <span style="color: red" :v-model="registerErrorMsg">{{
          registerErrorMsg
        }}</span>
      </el-form>

      <el-button @click="toLogin">返回登录</el-button>

      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="register">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
export default {
  data() {
    return {
      dialogFormVisible: false,
      registerInfo: {
        username: "",
        email: "",
        mobileNumber: "",
        password: "",
        reEnterPassword: "",
        text: "",
      },
      formLabelWidth: "120px",
      registerErrorMsg: "",
    };
  },
  methods: {
    register() {
      console.log("test");
      // axios向后端发送请求
      this.$http
        .post("http://localhost:8081/register", this.registerInfo)
        .then((res) => {
          console.log("success!");
          this.dialogFormVisible = false;
        })
        .catch((error) => {
          console.log("failed");
          console.log(error.response.data);
          this.registerErrorMsg = error.response.data.errorMessage;
          console.log(this.registerErrorMsg);
        });
    },
    toLogin() {
      this.$bus.$emit("showLogin", true);
      this.dialogFormVisible = false;
    },
  },
  mounted() {
    this.$bus.$on("showRegister", (data) => {
      console.log(data);
      this.dialogFormVisible = data;
    });
  },
  beforeDestroy() {
    this.$bus.$off("showRegister");
  },
};
</script>

<style scoped>
.el-input {
  background: rgb(243, 247, 255) !important;
}
</style>
