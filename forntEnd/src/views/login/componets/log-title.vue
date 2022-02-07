<!--
 * @Description: 登录页面标题
 * @Author: JunLiangWang
 * @Date: 2022-01-28 12:35:35
 * @LastEditors: JunLiangWang
 * @LastEditTime: 2022-02-07 14:31:09
-->
<template>
  <div class="title">{{ title }}</div>
  <div class="sub-title">{{ subTitle }}</div>
</template>
<script>
export default {
  name: "log-title",
  props: {
    title: {
      type: String,
      default: "",
    },
    subTitle: {
      type: String,
      default: "",
    },
  },
};
</script>
<style lang='scss' scoped>
.title {
  font-size: 48px;
  font-weight: bold;
}

.sub-title {
  font-size: 20px;
  letter-spacing: 1.5px;
  font-weight: bold;
}

@media screen and (max-width: 900px) {
  .title,
  .sub-title {
    text-align: center;
  }
}
</style>