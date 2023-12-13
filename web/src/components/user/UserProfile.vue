<template>
  <div>
    <div class="profile-part">
      <div class="profile-picture-frame">
        <div class="profile-picture"></div>
      </div>
      <div style="display: flex">
        <div class="profile-text-frame">
          <div class="profile-username">{{ user.username }}</div>
          <div class="profile-follow">
            <div style="color: rgb(255, 255, 255, 0.7)">关注</div>
            <div>{{ user.follows }}</div>
            <div style="color: rgb(255, 255, 255, 0.7); margin-left: 30px">
              粉丝
            </div>
            <div>{{ user.followers }}</div>
            <div style="color: rgb(255, 255, 255, 0.7); margin-left: 30px">
              获赞
            </div>
            <div>{{ user.liked }}</div>
          </div>
          <div class="profile-intro">
            <div style="color: rgb(255, 255, 255, 0.7)">抖音号:</div>
            <div style="color: rgb(255, 255, 255, 0.7)">
              {{ user.uniqueId }}
            </div>
          </div>
          <div class="profile-intro">
            <span>{{ user.notes }}</span>
          </div>
        </div>
        <div class="profile-right-frame">
          <div class="profile-right-edit">
            <button class="edit-button">编辑资料</button>
          </div>
        </div>
      </div>
    </div>

    <div class="user-bottom">
      <div class="user-bottom-content-frame">
        <div class="user-tabbar">
          <div class="user-tabbar-inner">
            <div class="user-tabber-inner-left">
              <!-- will be changed to router link -->
              <div class="user-works">
                <button class="user-tabbar-button">作品</button>
              </div>
              <div class="user-works">
                <button class="user-tabbar-button">喜欢</button>
              </div>
              <div class="user-works">
                <button class="user-tabbar-button">收藏</button>
              </div>
              <div class="user-works">
                <button class="user-tabbar-button">观看历史</button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<style>
.user-tabbar-button {
  font-size: 18px;
  background: transparent;
  border: 0px;
  color: white;
  cursor: pointer;
}
.user-works {
  align-items: center;
  cursor: pointer;
  display: flex;
  margin-right: 40px;
}
.user-tabber-inner-left {
  display: flex;
  height: 26px;
}
.user-tabbar-inner {
  align-items: center;
  display: flex;
  height: 36px;
  justify-content: space-between;
  margin: 11px 0;
  position: relative;
  width: 100%;
}
.user-tabbar {
  border-top: 1px solid rgb(255, 255, 255, 0.1);
  padding: 0;
}
.user-bottom-content-frame {
  margin: 0 auto;
  margin-top: 0px;
  margin-right: 60px;
  margin-bottom: 0px;
  margin-left: 60px;
}
.user-bottom {
  background: linear-gradient(
    270deg,
    #161823,
    #161823 14.66%,
    rgba(22, 24, 35, 0) 87.32%
  );
  margin-top: -16px;
  padding-top: 16px;
}
.profile-right-frame {
  bottom: 20px;
  align-content: space-between;
  align-items: center;
  bottom: 8px;
  flex-wrap: wrap;
  height: 112px;
  max-width: 280px;
  display: flex;
}
.profile-right-edit {
  display: flex;
  flex-direction: row-reverse;
  width: 100%;
}
.edit-button {
  width: 88px;
  height: 33px;
  border-radius: 12px;
  font-size: 13px;
  background: rgb(255, 255, 255, 0.3);
  border: 0px;
  color: white;
  cursor: pointer;
}
.el-main {
  line-height: 20px !important;
}
.profile-part {
  margin: 30px;
  height: 112px;
}
.profile-picture-frame {
  /* position: absolute; */
  float: left;
  width: 112px;
  height: 112px;
  text-align: center;
}
.profile-picture {
  width: 112px;
  height: 112px;
  background-image: url("../../assets/profilePic/profile1.jpg");
  background-size: cover;
  border-radius: 50%;
}
.profile-text-frame {
  height: 120px;
  min-height: 120px;
  align-content: center;
  align-items: center;
  display: flex;
  flex-wrap: wrap;
  flex: 1 1;
  /* text-align: left; */
  margin-left: 30px !important;
}
.profile-username {
  display: flex;
  position: relative;
  font-size: 20px;
}
.profile-follow {
  font-size: 15px;
  display: flex;
  width: 100%;
  margin-top: 4px;
}
.profile-intro {
  display: flex;
  margin-top: 12px;
  width: 100%;
}
.profile-text {
  display: flex;
  position: relative;
  margin: 4px;
  width: 100%;
}
</style>

<script>
export default {
  name: "UserProfile",
  data() {
    return {
      user: {
        username: "小猫借我玩两天",
        uniqueId: "abcdefghij",
        follows: 445,
        followers: 71,
        liked: 588,
        notes: "hello I am yy",
      },
    };
  },
};
</script>
