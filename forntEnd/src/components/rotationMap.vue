/*
 * @Author: WangJunLiang 
 * @Date: 2022-01-25 18:53:58 
 * @Last Modified by:   WangJunLiang 
 * @Last Modified time: 2022-01-25 18:53:58 、
 * 轮播图组件
 */
<template>
  <div class="container">
    <!--图片列表-->
    <div class="image-list">
      <a v-for="(item, index) in dataList" :href="item.linkUrl"
        :key="index" target="_blank" v-show="index == activeIndex">
        <img :src="item.imgUrl" :alt="item.details"/>
      </a>
    </div>
    <!--按钮列表-->
    <div class="button-list">
      <button  v-for="(item, index) in dataList"
        :key="index"  @mouseover="activeIndex = index"
        :class="activeIndex==index?'active':''">
      </button>
    </div>
  </div>
</template>

<script>
export default {
  name: "rotationMap",
  props: {
    dataList: {
      type: Array,
      default: () => [
        {
          imgUrl: require("@/assets/img/1.jpg"),
          linkUrl: "https:www.baidu.com",
          details: "测试图片",
        },
        {
          imgUrl: require("@/assets/img/2.jpg"),
          linkUrl: "https:www.baidu.com",
          details: "测试图片",
        },
        {
          imgUrl: require("@/assets/img/3.jpg"),
          linkUrl: "https:www.baidu.com",
          details: "测试图片",
        },
      ],
    },
    changeTime: {
      type: Number,
      default: 10,
    },
  },
  data() {
    return {
      activeIndex: 0,
    };
  },
  created(){
      //如果图片数量多于1，且开启自动切换图片
      if(this.dataList.length>1)
      {
          setInterval(this.changeImage, this.changeTime*1000);
      }
  },
  methods:{
      changeImage(){
          this.activeIndex++;
          if(this.activeIndex>=this.dataList.length)
          {
              this.activeIndex=0;
          }
      }
  }
};
</script>

<style scoped>
.container {
  position: relative;
}
.image-list,
a,
img,
figure,
.container {
  width: 100%;
  height: 100%;
}
a {
  display: block;
}
.button-list {
  position: absolute;
  bottom: 30px;
  display: flex;
  flex-wrap: nowrap;
  justify-content: center;
  flex-direction: row;
  width: 100%;
}
button {
  margin-right: 10px;
  width: 12px;
  height: 12px;
  border-radius: 100%;
  border: none;
  background: #ffffff17;
  cursor: pointer;
  box-shadow: 0 0 2px 0px #00000052;
}
button:hover,.active{
    transform: scale(1.15);
    box-shadow: 0 0 5px 0px #00000052;
}
</style>