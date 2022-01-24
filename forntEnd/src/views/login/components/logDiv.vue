<!--登录右页面居中的div-->
<template>
    <div class="login-div">
        <div class="center-div">
            <slot></slot>
        </div>
    </div>
</template>
<script>
    export default {}
</script>
<style lang='scss' scoped>
    .login-div {
        width: 100%;
        height: 100%;
        background-color: #3da2ff;
        display: flex;
        align-items: center;
        justify-content: center;
    }

    .center-div {
        height: 480px;
        width: 70%;
    }
</style>