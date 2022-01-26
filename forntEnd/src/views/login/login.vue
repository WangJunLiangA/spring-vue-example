<!--
 * @Description: 登录页面
 * @Author: JunLiangWang
 * @Date: 2022-01-20 10:58:58
 * @LastEditors: JunLiangWang
 * @LastEditTime: 2022-01-26 16:54:19
-->
<!--登录主页-->
<template>
  <!--全屏页面-->
  <div class="apn-div">
    <!--中间页面-->
    <div class="center-div">

      <!--左边页面-->
      <div class="sub-div">
        <rotation-map></rotation-map>
      </div>

      <!--右边页面-->
      <div class="sub-div">

      </div>

    </div>
  </div>
</template>
<script>
import rotationMap from '@/components/rotation-map.vue'

export default {
  name: "login",
  components:{
    rotationMap
  }
};
</script>
<style lang='scss' scoped>
.apn-div {
  position: absolute;
  width: 100%;
  top: 0;
  bottom: 0;
  background-repeat: no-repeat;
  background-size: 100% 100%;
  display: flex;
  align-items: center;
  justify-content: center;
}

.center-div {
  display: flex;
  width: 900px;
  height: 550px;
  box-shadow: 0px 0px 7px 0px #a1a1a1;
}

.sub-div {
  width: 50%;
  height: 100%;
  display: flex;
  align-items: center;
}

@media screen and (max-width: 900px) {
  .center-div,
  .center-div:hover {
    box-shadow: none;
    height: 100%;
    width: 100%;
  }

  .sub-div {
    width: 100%;
    height: 100%;
  }

  .sub-div {
    display: none;  
  }
}
</style>