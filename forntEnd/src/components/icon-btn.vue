<!--
 * @Description: 带图标按钮
 * @Author: JunLiangWang
 * @Date: 2022-02-07 14:19:03
 * @LastEditors: JunLiangWang
 * @LastEditTime: 2022-02-07 14:27:22
-->
<template>
     <div class="btn" @click="btnClick">
        <i :class="icon"></i>
     </div>
</template>

<script>
export default {
  name:"icon-btn",
  props:{
      icon:{
          type:String,
          default:""
      }
  },
  methods:{
      btnClick(){
          this.$emit("btnClick")
      }
  }
}
</script>

<style lang="scss" scoped>
.btn{
    border: solid 1.5px #c1c5cc;
    border-radius: 3px;
    cursor: pointer;
    display: flex;
    justify-content: center;
    align-items: center;
    i{
      color: #c1c5cc;
      font-size: 20px;
    }

}
.btn:hover{
    border-color: #68bd45;
    i{
      color: #68bd45;
    }
}
</style>