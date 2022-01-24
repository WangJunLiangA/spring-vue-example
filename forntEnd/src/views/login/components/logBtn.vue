<!--登录页面右边的按钮
    props:title 按钮文本
    methods:click 按钮点击
-->
<template>
    <button class="logButton" @click="clickBtn" >{{title}}</button>
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
        border: 1px solid #1c65ff;
        transition: ease all 0.5s;
        background-color: #1c65ff;
        color: #fff;
        font-weight: 600;
    }

    .logButton:hover {
        background-color: #4b84ff;
        border: 1px solid #4b84ff;
    }
</style>