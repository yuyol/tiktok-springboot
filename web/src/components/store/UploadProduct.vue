<template>
  <div>
    <div class="frame">
      <div class="inner-frame">
        <div class="upload-frame">
          <div style="padding-top: 10px"><h1>商品名称*</h1></div>
          <input v-model="title" placeholder="请输入名称" class="input" />

          <div style="padding-top: 10px"><h1>商品价格*</h1></div>
          <input v-model="price" placeholder="请输入价格" class="input" />

          <div style="padding-top: 10px"><h1>商品描述*</h1></div>
          <el-input
            type="textarea"
            :rows="2"
            placeholder="请输入内容"
            v-model="description"
          >
          </el-input>

          <div style="padding-top: 10px"><h1>商品图片*</h1></div>
          <el-upload
            class="upload-demo"
            ref="upload"
            action="string"
            accept="image/jpeg,image/png,image/jpg"
            list-type="picture-card"
            :before-upload="onBeforeUploadImage"
            :on-change="fileChange"
            :on-remove="removeFile"
            :file-list="fileList"
            :auto-upload="false"
            :multiple="true"
          >
            <el-button size="small" type="primary">点击上传</el-button>
            <div slot="tip" class="el-upload__tip">
              只能上传jpg/jpeg/png文件，且不超过500kb
            </div>
          </el-upload>

          <div style="padding-top: 10px"><h1>商品分类*</h1></div>
          <div style="margin-top: 20px">
            <el-checkbox-group v-model="checkboxGroup" size="small">
              <el-checkbox-button
                v-for="category in categories"
                :label="category.id"
                :key="category.id"
                >{{ category.name }}</el-checkbox-button
              >
            </el-checkbox-group>
          </div>

          <div style="padding-top: 10px"><h1>商品尺码*</h1></div>
          <div style="margin-top: 20px">
            <el-select
              v-model="value"
              filterable
              allow-create
              default-first-option
              placeholder="请选择或自定义尺码"
              style="
                border: 1px solid;
                border-radius: 5px;
                border: 1px solid rgb(0, 0, 0, 0.1);
              "
            >
              <el-option
                v-for="item in options"
                :key="item.value"
                :label="item.label"
                :value="item.value"
              >
              </el-option>
            </el-select>
          </div>

          <el-button
            type="primary"
            plain
            @click="sumbit()"
            style="margin-bottom: 30px; margin-top: 20px"
            >上传</el-button
          >
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      //文件数组
      fileArr: [],
      //页面显示的图片文件数组
      fileList: [],
      title: "",
      price: 0.0,
      description: "",
      categories: [
        { id: 1, name: "女装", label: "womenswear" },
        { id: 2, name: "男装", label: "mensClothes" },
        { id: 3, name: "美妆", label: "beautyCare" },
        { id: 4, name: "护理", label: "nursingCare" },
        { id: 5, name: "腕表", label: "wristwatches" },
        { id: 6, name: "眼镜", label: "glasses" },
        { id: 7, name: "鞋包", label: "bags" },
        { id: 8, name: "珠宝饰品", label: "Jewelry" },
        { id: 9, name: "手机", label: "mobilePhone" },
        { id: 10, name: "数码", label: "digital" },
        { id: 11, name: "零食", label: "snacks" },
        { id: 12, name: "茶酒", label: "teaWine" },
        { id: 13, name: "生鲜水果", label: "freshFruit" },
        { id: 14, name: "电器", label: "device" },
        { id: 15, name: "家具", label: "furniture" },
        { id: 16, name: "灯具", label: "luminaire" },
        { id: 17, name: "汽车", label: "car" },
        { id: 18, name: "家饰", label: "homeDecor" },
        { id: 19, name: "鲜花", label: "flower" },
        { id: 20, name: "医药保健", label: "healthcare" },
        { id: 21, name: "厨具", label: "cookware" },
        { id: 22, name: "宠物", label: "pet" },
        { id: 23, name: "图书音像", label: "bookVideos" },
      ],
      checkboxGroup: [],
      userId: 0,
      options: [
        {
          value: "XXS",
          label: "XXS",
        },
        {
          value: "XS",
          label: "XS",
        },
        {
          value: "S",
          label: "S",
        },
        {
          value: "M",
          label: "M",
        },
        {
          value: "L",
          label: "L",
        },
        {
          value: "XL",
          label: "XL",
        },
        {
          value: "XXL",
          label: "XXL",
        },
      ],
      value: [],
    };
  },
  methods: {
    //上传之前的钩子,自定义上传后，该钩子失效
    onBeforeUploadImage(file) {},
    //文件改变钩子
    fileChange(file, fileList) {
      // if (this.fileArr.length > 0) {
      //   //写的是多图上传，但是这个模块只用到了单图，所以加个判断，多图的可以留着后面用
      //   this.$message.error("当前背景图只支持单张上传");
      //   fileList = fileList.pop();
      //   return;
      // }
      const isIMAGE = file.type === "image/jpeg" || "image/jpg" || "image/png";
      const isLt1M = file.size / 1024 / 1024 < 1;
      if (!isIMAGE) {
        this.$message.error("上传文件只能是图片格式!");
      }
      if (!isLt1M) {
        this.$message.error("上传文件大小不能超过 1MB!");
      }
      //将文件存到数组中
      this.fileArr.push(file.raw);
    },
    //提交事件
    sumbit() {
      const formData = new FormData();
      //这一步要特别注意！！！如果直接formData.append("files",this.fileArr)，那么后端将会收不到参数，一定一定要遍历这个数组然后一个个重新append formdata中
      for (var i = 0; i < this.fileArr.length; i++) {
        formData.append("files", this.fileArr[i]);
      }

      //填充商品分类
      for (var i = 0; i < this.checkboxGroup.length; i++) {
        formData.append("category", this.checkboxGroup[i]);
      }

      console.log(this.value[0]);

      formData.append("title", this.title);
      formData.append("price", this.price);
      formData.append("description", this.description);
      formData.append("user_id", this.userId);
      formData.append("type", this.value[0]);
      console.log(this.checkboxGroup);
      this.$http.post(
        "http://localhost:8101/uploadProduct",
        // JSON.stringify(this.uploadForm),
        formData,
        {
          headers: {
            // "Content-Type": "application/json",
            "Content-Type": "multipart/form-data",
          },
        }
      );
    },
    //移除文件的钩子
    removeFile(file, fileList) {
      for (var i = 0; i < this.fileArr.length; i++) {
        //如果传入的文件uid和即将提交的图片数组中的某个uid一致，那么移除此图片
        if (file.raw.uid == this.fileArr[i].uid) {
          this.fileArr.splice(this.fileArr[i], 1);
        }
      }
    },
  },
  mounted() {
    let userInfo = JSON.parse(localStorage.getItem("user"));
    var userId = userInfo.data.userId;
    this.userId = userId;
  },
};
</script>

<style scoped>
.frame {
  margin-left: 30px;
  margin-right: 30px;
}
.inner-frame {
  margin: 0 auto;
  text-align: left;
  width: 800px;
  background: white;
  color: black;
  border-radius: 10px;
}
.upload-frame {
  width: 500px;
  margin: 0 auto;
}
.input {
  width: 300px;
  height: 40px;
  border-radius: 5px;
  border: 1px solid rgb(0, 0, 0, 0.1);
  font-size: 13px;
  padding-left: 15px;
}
.input:focus {
  outline: none;
  border: 1px solid #409eff;
}
</style>
