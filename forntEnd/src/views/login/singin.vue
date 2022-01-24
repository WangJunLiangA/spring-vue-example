<!--登录页面 未完差路由跳转-->
<template>
    <!--登录左边有边距且居中的大Div-->
    <log-div>
        <!--标题-->
        <log-title title="欢迎登录" subTitle="welcome to login"></log-title>
        <!--账号框-->
        <div style="margin-top:60px;">
            <icon-input v-model="account" icon="Avatar" v-model:curFocusCm="curFocusCm" placeholder="请输入账号">
            </icon-input>
        </div>
        <!--密码框-->
        <div style="margin-top:15px;">
            <icon-input :isCaps="isCaps" v-model="password" v-model:curFocusCm="curFocusCm"  icon="el-icon-s-goods"
                :isPassword="true" placeholder="请输入密码"></icon-input>
        </div>
        <!--保持登录与忘记密码框-->
        <div style="margin-top:20px;display:flex">
            <div class="check-div">
                <input type="checkbox" v-model="isHoldOn" />
                <touch-label @touchLb="isHoldOn=!isHoldOn" style="margin-left:5px;" content="保持登录"></touch-label>
            </div>
            <div class="check-div left">
                <touch-label style="margin-left:5px;" @touchLb="toForgetPassword" content="忘记密码"></touch-label>
            </div>
        </div>
        <!--登录按钮框-->
        <div style="margin-top:40px;display:flex;height:50px;font-size:25px;">
            <log-btn v-loading="loging" element-loading-background="#1c65ff" @click="singin" title="登 录"></log-btn>
        </div>
        <!--声明框-->
        <div style="margin-top: 80px;text-align: center;color: #fff;"> © 2020 1024Sutiod保留所有权利 </div>
    </log-div>
</template>
<script>
    import iconInput from './components/iconInput'
    import touchLabel from './components/touchLabel'
    import logTitle from './components/logTitle'
    import logDiv from './components/logDiv'
    import logBtn from './components/logBtn'
    export default {
        components: {
            iconInput,
            touchLabel,
            logTitle,
            logDiv,
            logBtn,
        },
        data() {
            return {
                account: '',
                password: '',
                isHoldOn: false,
                loging: false,
                isCaps: false,
                curFocusCm: null,
            }
        },
        methods: {
            /**登录请求 */
            singin() {
                if (this.account == "") {
                    this.$msg.error("请输入账号");
                    return;
                }
                if (this.password == "") {
                    this.$msg.error("请输入密码");
                    return;
                }
                this.loging = true;
                let that = this;
                this.$netApi.accMg.workerLogin_api(this.account, this.password)
                    .then(function (response) {
                        that.loging = false;
                        if (response.data.code == that.$netApi.requestsuccess) {
                            sessionStorage.setItem("token", response.data.data);
                            if (that.isHoldOn == true) {
                                localStorage.setItem("token", response.data.data);
                            }
                            that.$router.replace("/mainPage")
                        } else {
                            that.$msg.error(response.data.message);
                        }
                    })
                    .catch(function () {
                        that.loging = false;
                        that.$msg.error('登录失败');
                    });
            },
            /**跳转到忘记密码 */
            toForgetPassword() {
                this.$router.push('/forget')
            }
        },
        mounted() {
            /*回车快捷键*/
            var that = this;
            document.onkeydown = function () {
                var key = window.event.keyCode;
                if (key == 13) {
                    that.singin();
                }
                that.isCaps = window.event.getModifierState('CapsLock');
            }
        },
        beforeUnmount() {
            /*清除快捷键*/
            document.onkeydown = null;
        }
    }
</script>
<style lang='scss' scoped>
    .check-div {
        width: 50%;
        font-size: 18px;
        font-weight: 700;
    }
    
    .left {
        text-align: end;
    }
</style>