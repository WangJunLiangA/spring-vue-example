<!--
 * @Description: 登录按钮
 * @Author: JunLiangWang
 * @Date: 2022-02-01 16:18:28
 * @LastEditors: JunLiangWang
 * @LastEditTime: 2022-02-01 16:27:42
-->
<template>
    <button class="logButton" @click="clickBtn">{{title}}</button>
</template>

<script>
    export default {
        props: {
            title: {
                type:String,
                default:""
            },
        },
        methods: {
            clickBtn() {
                this.$emit("click");
            }
        }
    }
</script>
<style lang='scss' scoped>
    .logButton {
        width: 100%;
        height: 100%;
        outline: 0;
        border-radius: 3px;
        border: 1px solid #68bd45;
        transition: ease all 0.5s;
        background-color: #68bd45;
        color: #fff;
        cursor: pointer;
    }

    .logButton:hover {
        background-color: #519435;
        border: 1px solid #519435;
    }
</style>