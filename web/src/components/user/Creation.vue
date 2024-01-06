<template>
  <div class="bottom-frame">
    <div class="creation-frame">
      <div class="creation-inner-frame">
        <div style="font-size: 20px; margin-top: 15px">上传视频</div>
        <el-upload
          class="upload-demo"
          drag
          action="http://localhost:8091/upload"
          v-bind:on-progress="uploadVideoProcess"
          v-bind:on-success="handleVideoSuccess"
          v-bind:before-upload="beforeUploadVideo"
          v-bind:show-file-list="false"
          multiple
        >
          <i class="el-icon-upload"></i>
          <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
          <!-- <div class="el-upload__tip" slot="tip">
          只能上传jpg/png文件，且不超过500kb
        </div> -->
        </el-upload>
        <video
          v-if="videoForm.showVideoPath != '' && !videoFlag"
          v-bind:src="videoForm.showVideoPath"
          class="avatar video-avatar"
          controls="controls"
        >
          您的浏览器不支持视频播放
        </video>
        <div style="display: flex; margin-top: 15px">
          <div style="font-size: 18px; padding-top: 5px">标题：</div>
          <input type="text" class="input" />
        </div>
        <div style="display: flex; margin-top: 15px">
          <div style="font-size: 18px; padding-top: 5px">简介：</div>
          <input type="text" class="input" />
        </div>
        <div style="display: flex; margin-top: 15px">
          <button class="submit">上传视频</button>
        </div>
      </div>
    </div>
    <div class="bottom-right-frame">ABCD</div>
  </div>
</template>
<style scoped>
.upload-demo {
  padding-top: 20px;
  width: 400px;
}
.bottom-frame {
  width: 1200px;
  display: flex;
  margin: 0 auto;
  /* background: black; */
}
.creation-frame {
  width: 600px;
  margin-left: 30px;
  margin-right: 30px;
  background: black;
  /* width: 360px; */
  text-align: left;
}
.creation-inner-frame {
  width: 360px;

  margin: 0 auto;
}
.avatar {
  width: 300px;
  height: 178px;
  display: block;
}
.bottom-right-frame {
  width: 600px;
}
.input {
  width: 300px;
  height: 30px;
  border-radius: 10px;
  border: 0px;
}
.submit {
  width: 100px;
  height: 45px;
  font-size: 15px;
  border-radius: 15px;
  cursor: pointer;
}
</style>
<script>
export default {
  name: "IndexIconMenu",
  data() {
    return {
      videoFlag: false,
      //是否显示进度条
      videoUploadPercent: "",
      //进度条的进度，
      isShowUploadVideo: false,
      //显示上传按钮
      videoForm: {
        showVideoPath: "", //回显的变量
      },
    };
  },
  methods: {
    beforeUploadVideo(file) {
      var fileSize = file.size / 1024 / 1024 < 1024; //控制大小  修改50的值即可
      if (
        [
          "video/mp4",
          "video/ogg",
          "video/flv",
          "video/avi",
          "video/wmv",
          "video/rmvb",
          "video/mov",
        ].indexOf(file.type) == -1 //控制格式
      ) {
        layer.msg("请上传正确的视频格式");
        return false;
      }
      if (!fileSize) {
        layer.msg("视频大小不能超过50MB");
        return false;
      }
      this.isShowUploadVideo = false;
    },
    //进度条
    uploadVideoProcess(event, file, fileList) {
      //注意在data中添加对应的变量名
      this.videoFlag = true;
      this.videoUploadPercent = file.percentage.toFixed(0) * 1;
    },
    //上传成功回调
    handleVideoSuccess(res, file) {
      this.isShowUploadVideo = true;
      this.videoFlag = false;
      this.videoUploadPercent = 0;

      console.log(res);
      console.log(res.url);
      console.log(res.success);
      //后台上传数据
      if (res.success == true) {
        this.videoForm.showVideoPath = res.url; //上传成功后端返回视频地址 回显
        this.$message.success("上传成功！");
      } else {
        this.$message.error("上传失败！");
      }
    },
  },
};
</script>
