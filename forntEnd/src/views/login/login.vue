<!--登录主页-->
<template>
    <!--全屏页面-->
    <div class="apn-div">
        <!--中间页面-->
        <div class="center-div">
            <!--左边页面-->
            <div class="sub-div left">
                <img src="@/assets/img/login_bill.gif" style="width:100%;" />
            </div>
            <!--右边页面-->
            <div class="sub-div">
                    <router-view />
            </div>
        </div>
    </div>
    <!--1.国际化
        2.无障碍
        3.手机端适配
        4.兼容
    -->
</template>
<script>
    export default {
        name:"login"
    }
</script>
<style lang='scss' scoped>
    .apn-div {
        position: absolute;
        width: 100%;
        top: 0;
        bottom: 0;
        background: url('../../assets/img/login_background.png');
        background-repeat: no-repeat;
        background-size: 100% 100%;
        display: flex;
        align-items: center;
        justify-content: center;
    }

    .center-div {
        display: flex;
        width: 900px;
        height: 550px;
        box-shadow: 0px 0px 7px 0px #a1a1a1;
    }

    .center-div:hover {
        box-shadow: 0px 0px 12px 0px #70a7fffc;
    }

    .sub-div {
        width: 50%;
        height: 100%;
        display: flex;
        align-items: center;
    }

    @media screen and (max-width: 900px) {
        .center-div,
        .center-div:hover {
            box-shadow: none;
            height: 100%;
            width: 100%;
        }

        .sub-div {
            width: 100%;
            height: 100%;
        }

        .left {
            display: none;
        }
    }
</style>