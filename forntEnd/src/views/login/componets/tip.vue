<!--
 * @Description: 
 * @Author: JunLiangWang
 * @Date: 2022-01-28 15:45:35
 * @LastEditors: JunLiangWang
 * @LastEditTime: 2022-01-31 21:55:17
-->
<template>
  <div v-show="visible" class="tip-div">
    <div class="marker-div">
      <div class="marker"></div>
    </div>
    <div class="content-div">
      <div class="content">{{ content }}</div>
    </div>
  </div>
</template>

<script>
export default {
  props: {
    content: {
      type: String,
      default: "",
    },
    visible: {
      type: Boolean,
      default: false,
    },
  },
};
</script>

<style scoped>
.tip-div {
  position: absolute;
  margin-top: 10px;
  text-align: center;
  z-index: 10;
}

.marker-div {
  height: 10px;
  display: flex;
  justify-content: center;
}

.marker {
  width: 10px;
  height: 10px;
  background: white;
  transform: rotate(45deg);
  border: solid 1.5px #68bd45;
  z-index: 0;
}

.content-div {
  background: white;
  height: 25px;
  width: 100px;
  display: flex;
  margin-top: -5px;
  border-radius: 4px;
  border: solid 1.5px #68bd45;
}

.content {
  background: white;
  height: 100%;
  width: 100%;
  z-index: 1;
  display: flex;
  align-items: center;
  justify-content: center;
  border-radius: 4px;
  font-size: 14px;
}
</style>