<!--登录页面右边标题
    props:  title     主标题
            subTitle  副标题
-->
<template>
    <div>
        <div class="title">{{title}}</div>
        <div class="sub-title">{{subTitle}}</div>
    </div>
</template>
<script>
    export default {
        props: {
            title: {
                type:String,
                default:""
            },
            subTitle:{
                type:String,
                default:""
            },
        }
    }
</script>
<style lang='scss' scoped>
    .title {
        font-size: 48px;
        font-weight: bold;
        color: white
    }

    .sub-title {
        font-size: 20px;
        letter-spacing: 1.5px;
        font-weight: bold;
        color: white;
    }

    @media screen and (max-width: 900px) {

        .title,
        .sub-title {
            text-align: center;
        }
    }
</style>