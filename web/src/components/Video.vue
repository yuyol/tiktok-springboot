<template>
  <div class="videoFrame">
    <div class="VideoPart">Video</div>
    <div class="commentSec">Comment</div>
  </div>
</template>

<script></script>

<style>
.videoFrame {
  width: auto;
  height: 100%;
  background: black;
  border-radius: 20px;
  display: flex;
}

.VideoPart {
  min-width: 100px;
  /* float: left; */
  width: 100%;
}

.commentSec {
  width: 300px;
  min-width: 300px;
  height: 100%;
  background: rgb(255, 255, 255, 0.1);
  /* float: right; */
  display: block;
  border-radius: 20px;
}
</style>
