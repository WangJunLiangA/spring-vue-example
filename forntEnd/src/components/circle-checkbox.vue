<!--
 * @Description: 圆形复选框
 * @Author: JunLiangWang
 * @Date: 2022-02-01 15:32:26
 * @LastEditors: JunLiangWang
 * @LastEditTime: 2022-02-01 16:06:48
-->
<template>
  <div class="checkbox-container">
    <input id="clCheckbox" type="checkbox" v-model="isCheck"/>
    <label class="checkbox-label" for="clCheckbox"></label>
    <label class="title" @click="isCheck=!isCheck">{{title}}</label>
  </div>
</template>

<script>
export default {
  name: "circle-checkbox",
  props:{
      //显示标题
      title:{
          type:String,
          default:""
      },
      //v-model
      modelValue:{
          type:Boolean,
          default:false
      }
  },
  data(){
      return {
          isCheck:this.modelValue
      }
  },
  watch:{
      isCheck(nv)
      {
          this.$emit("update:modelValue",nv)
      },
      modelValue(nv)
      {
        this.isCheck=nv;
      }
  }
};
</script>

<style scoped>
.checkbox-container
{
    display: flex;
    flex-direction: row;
    align-items: center;
}
input {
  width: 0px;
}
.checkbox-label {
  border-radius: 100%;
  border: solid 2px #68bd45;
  display: block;
  width: 12px;
  height: 12px;
  cursor: pointer;
}
input:checked + .checkbox-label::before {
  display: block;
  content: "\2714";
  text-align: center;
  vertical-align: middle;
    font-size: 12px;
  color: white;
}
input:checked + .checkbox-label {
  background: #68bd45;
}
.title{
    margin-left:5px;
    cursor: pointer;
}
</style>