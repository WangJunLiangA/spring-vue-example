<!--密码框大小写提示框
    props:  content 提示内容
            visible 是否显示
-->
<template>
    <div v-if="visible" class="tip-div ">
        <div class="marker-div">
            <div class="marker"></div>
        </div>
        <div class="content-div">
            <div class="content">{{content}}</div>
        </div>
    </div>
</template>

<script>
    export default {
        props: {
            content:{
                type:String,
                default:""
            },
            visible: {
                type:Boolean,
                default:false
            },
        }
    }
</script>

<style scoped>
    .tip-div {
        position: absolute;
        margin-top: 45px;
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
        box-shadow: #a9a6a6 0 0 4px 1px;
        z-index: 0;
    }

    .content-div {
        background: white;
        height: 25px;
        width: 100px;
        display: flex;
        margin-top: -5px;
        border-radius: 4px;
        box-shadow: #a9a6a6 0 0 4px 1px;
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