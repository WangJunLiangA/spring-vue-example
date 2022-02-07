<!--
 * @Description: 登录页面
 * @Author: JunLiangWang
 * @Date: 2022-01-20 10:58:58
 * @LastEditors: JunLiangWang
 * @LastEditTime: 2022-02-07 16:42:17
-->
<!--登录主页-->
<template>
  <!--全屏页面-->
  <div class="apn-div">
    <!--中间页面-->
    <div class="center-div slide-in-top">
      <!--左边页面-->
      <div class="sub-div">
        <rotation-map></rotation-map>
      </div>

      <!--右边页面-->
      <div class="sub-div">
        <router-view></router-view>
      </div>
    </div>

    <!--页面5个小球-->
    <div class="circular circular1 slide-in-top"></div>
    <div class="circular circular2 slide-in-top"></div>
    <div class="circular circular3 slide-in-bottom"></div>
    <div class="circular circular4 slide-in-bottom"></div>
    <div class="circular circular5 slide-in-bottom"></div>
    <div class="circular circular6 slide-in-bottom"></div>
  </div>
</template>
<script>
//轮播图组件
import rotationMap from "@/components/rotation-map.vue";
export default {
  name: "login",
  components: {
    rotationMap,
  },
};
</script>
<style lang='scss' scoped>
.apn-div {
  position: fixed;
  width: 100%;
  top: 0;
  right: 0;
  bottom: 0;
  left: 0;
  display: flex;
  align-items: center;
  justify-content: center;
  background: #ededed;
}
.center-div {
  display: flex;
  width: 1000px;
  height: 650px;
  box-shadow: 0px 0px 20px 0px #4545456e;
  z-index: 100;
  background: white;
  border-radius: 5px;
  overflow: hidden;
}
.sub-div {
  width: 50%;
  height: 100%;
  display: flex;
  align-items: center;
}
.sub-div:nth-child(1) {
  background: #68bd45;
}

.circular {
  position: absolute;
  border-radius: 100%;
  z-index: 50;
  box-shadow: 0 0 14px #cecece;
}
.circular1 {
  right: -120px;
  top: -240px;
  width: 400px;
  height: 400px;
  background: #68bd45;
}
.circular2 {
  left: -50px;
  top: -50px;
  width: 200px;
  height: 200px;
  background: #34495e;
}
.circular3 {
  left: -140px;
  bottom: -180px;
  width: 650px;
  height: 650px;
  background: #41b883;
}
.circular4 {
  right: 157px;
  bottom: 111px;
  width: 110px;
  height: 110px;
  background: #68bd45;
}
.circular5 {
  width: 60px;
  height: 60px;
  background: #34495e;
  right: 151px;
  bottom: 15px;
}
.circular6 {
  width: 80px;
  height: 80px;
  background: #41b883;
  right: 60px;
  bottom: 70px;
}
//响应式布局
@media screen and (max-width: 900px) {
  .center-div,
  .center-div:hover {
    box-shadow: none;
    height: 100%;
    width: 100%;
    border-radius: 0;
  }

  .sub-div {
    width: 100%;
    height: 100%;
  }

  .sub-div:nth-child(1) {
    display: none;
  }
}
.slide-in-top {
  -webkit-animation: slide-in-top 0.6s cubic-bezier(0.25, 0.46, 0.45, 0.94) both;
  animation: slide-in-top 0.6s cubic-bezier(0.25, 0.46, 0.45, 0.94) both;
}
.slide-in-bottom {
  -webkit-animation: slide-in-bottom 0.6s cubic-bezier(0.25, 0.46, 0.45, 0.94)
    both;
  animation: slide-in-bottom 0.6s cubic-bezier(0.25, 0.46, 0.45, 0.94) both;
}
//动画
@-webkit-keyframes slide-in-top {
  0% {
    -webkit-transform: translateY(-100%);
    transform: translateY(-100%);
    opacity: 0;
  }
  100% {
    -webkit-transform: translateY(0);
    transform: translateY(0);
    opacity: 1;
  }
}
@keyframes slide-in-top {
  0% {
    -webkit-transform: translateY(-100%);
    transform: translateY(-100%);
    opacity: 0;
  }
  100% {
    -webkit-transform: translateY(0);
    transform: translateY(0);
    opacity: 1;
  }
}
@-webkit-keyframes slide-in-bottom {
  0% {
    -webkit-transform: translateY(100%);
    transform: translateY(100%);
    opacity: 0;
  }
  100% {
    -webkit-transform: translateY(0);
    transform: translateY(0);
    opacity: 1;
  }
}
@keyframes slide-in-bottom {
  0% {
    -webkit-transform: translateY(100%);
    transform: translateY(100%);
    opacity: 0;
  }
  100% {
    -webkit-transform: translateY(0);
    transform: translateY(0);
    opacity: 1;
  }
}
</style>