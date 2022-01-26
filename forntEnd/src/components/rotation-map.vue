<!--
 * @Description: 轮播图插件
 * @Author: JunLiangWang
 * @Date: 2022-01-25 10:06:04
 * @LastEditors: JunLiangWang
 * @LastEditTime: 2022-01-26 16:53:45
-->
<template>
  <div class="container">
    <!--图片列表-->
    <div class="image-list">
      <transition name="fade" v-for="(item, index) in dataList" :key="index">
        <a :href="item.linkUrl" target="_blank" v-show="index == activeIndex">
          <img :src="item.imgUrl" :alt="item.details" />
        </a>
      </transition>
    </div>
    <!--按钮列表-->
    <div class="button-list">
      <button
        v-for="(item, index) in dataList"
        :key="index"
        @mouseover="activeIndex = index"
        :class="activeIndex == index ? 'active' : ''"
      ></button>
    </div>
  </div>
</template>

<script>
export default {
  name: "rotation-map",
  props: {
    //图片列表
    dataList: {
      type: Array,
      default: () => [
        {
          imgUrl: require("@/assets/img/1.jpg"), //图片地址
          linkUrl: "https:www.baidu.com", //点击链接
          details: "测试图片", //图片描述
        },
        {
          imgUrl: require("@/assets/img/2.jpg"), //图片地址
          linkUrl: "https:www.baidu.com", //点击链接
          details: "测试图片", //图片描述
        },
        {
          imgUrl: require("@/assets/img/3.jpg"), //图片地址
          linkUrl: "https:www.baidu.com", //点击链接
          details: "测试图片", //图片描述
        },
      ],
    },
    //切换图片时间
    changeTime: {
      type: Number,
      default: 5,
    },
    //是否开启自动切换图片
    isEnableAutoChangeImg: {
      type: Boolean,
      default: true,
    },
  },
  data() {
    return {
      //当前激活图片索引
      activeIndex: 0,
      //定时器
      time: null,
    };
  },
  watch: {
    isEnableAutoChangeImg(value) {
      this.isAutoChangeImg(value,this.dataList,this.changeTime);
    },
    dataList(value) {
      this.isAutoChangeImg(this.isEnableAutoChangeImg,value,this.changeTime);
    },
    changeTime(value)
    {
      if(this.time!=null)
      {
        clearInterval(this.time);
      }
      this.isAutoChangeImg(this.isEnableAutoChangeImg,this.dataList,value)
    }
  },
  methods: {
    /**
     * @description: 是否开启或关闭自动切换图片
     * @author: JunLiangWang
     * @param {*} isEnableAutoChangeImg   是否开启自动切换图片
     * @param {*} length 图片列表长度
     * @param {*} changeTime  切换时间
     * @return {*}
     */    
    isAutoChangeImg(isEnableAutoChangeImg,length,changeTime) {
      if(isEnableAutoChangeImg && length.length>1)
      {
        if(this.time==null)
        {
         this.time = setInterval(this.changeImage, changeTime * 1000);
        }
      }
      else
      {
        if(this.time!=null)
        {
          clearInterval(this.time);
          this.time=null;
        }
      }
      this.activeIndex=0;
    },
    /**
     * @description: 切换图片
     * @author: JunLiangWang
     * @param {*}
     * @return {*}
     */    
    changeImage() {
      this.activeIndex++;
      if (this.activeIndex >= this.dataList.length) {
        this.activeIndex = 0;
      }
    }
  },
  created(){
      this.isAutoChangeImg(this.isEnableAutoChangeImg,this.dataList,this.changeTime)
  }
};
</script>

<style scoped>
.container,
.image-list {
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
a,
.button-list {
  display: block;
  position: absolute;
}
.image-list {
  overflow: hidden;
}
.button-list {
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
button:hover,
.active {
  transform: scale(1.15);
  box-shadow: 0 0 5px 0px #00000052;
}

/**
  动画
 */
.fade-enter-active,
.fade-leave-active {
  transition: opacity 1s ease;
}

.fade-enter-from,
.fade-leave-to {
  opacity: 0;
}
</style>