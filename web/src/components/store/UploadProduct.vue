<template>
  <div>
    <div class="frame">
      <div class="inner-frame">
        <div class="upload-frame">
          <div style="padding-top: 10px"><h1>商品名称*</h1></div>
          <el-input placeholder="请输入内容"></el-input>

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

          <el-button type="primary" plain @click="sumbit()">上传</el-button>
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
      uploadForm: {
        uploadInfos: [],
        files: [],
      },
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

      formData.append("title", "abc");
      // 从上传文件中获取文件信息
      let form = this.$refs.upload.uploadFiles;
      this.uploadForm.uploadInfos = form;
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
</style>
