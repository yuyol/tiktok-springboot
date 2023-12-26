<template>
  <div class="videoFrame">
    <!-- <div style="display: flex; width: 100%">
      <div class="VideoPart">Video</div>
      <div class="commentSec">Comment</div>
    </div> -->

    <!-- Test -->
    <div class="swiper-container">
      <div class="swiper-wrapper">
        <div class="swiper-slide">
          <div class="VideoPart">
            <video
              v-if="videoForm.showVideoPath != '' && !videoFlag"
              v-bind:src="videoForm.showVideoPath"
              class="videoContent"
              controls="controls"
            >
              您的浏览器不支持视频播放
            </video>
          </div>
          <div class="commentSec">Comment 1</div>
        </div>
        <div class="swiper-slide">
          <div class="VideoPart">Video 2</div>
          <div class="commentSec">Comment 2</div>
        </div>
        <div class="swiper-slide">
          <div class="VideoPart">Video 3</div>
          <div class="commentSec">Comment 3</div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import Swiper from "swiper";
import "swiper/css/swiper.min.css";
export default {
  name: "carrousel",
  data() {
    return {
      swiperOptions: {
        pagination: {
          el: ".swiper-pagination",
        },
        // Some Swiper option/callback...
      },
      videoForm: {
        showVideoPath: "",
      },
    };
  },
  computed: {
    swiper() {
      return this.$refs.mySwiper.$swiper;
    },
  },
  mounted() {
    new Swiper(".swiper-container", {
      direction: "vertical", // 垂直切换选项
      loop: false, // 循环模式选项
      mousewheel: true,
    });
    this.getVideo();
  },
  methods: {
    getVideo() {
      this.$http.get("http://localhost:8091/getVideo").then((res) => {
        console.log(res.data.url);
        this.videoForm.showVideoPath = res.data.url;
      });
    },
  },
};
</script>

<style>
.videoFrame {
  width: auto;
  height: 100%;
  background: black;
  border-radius: 20px;
  display: flex;
}
.videoContent {
  width: 100%;
}

.swiper-container {
  width: 100%;
  height: 100%;
  margin: 0 auto;
  background: transparent;
  border-radius: 20px;
}

.swiper-slide {
  display: flex;
  width: 100%;
}

.VideoPart {
  min-width: 100px;
  /* float: left; */
  width: 100%;
  color: white;
}

.commentSec {
  width: 300px;
  min-width: 300px;
  height: 100%;
  background: rgb(255, 255, 255, 0.1);
  color: white;
  /* float: right; */
  display: block;
  border-radius: 20px;
}
</style>
