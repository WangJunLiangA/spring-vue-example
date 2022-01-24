<!--带图标的文本框
    普通文本框   v-model,icon,placeholder,curFocusCm.sync(当前激活对象,当存在需要显示提示框的时候需要绑定改属性)
    密码框       以上,isPassword=true,isCaps(是否大写),curFocusCm.sync(当前激活对象,当存在需要显示提示框的时候需要绑定改属性)
    验证码框     普通文本框，isCoder,loading,title,@coderClick,codeBtnDisabled,curFocusCm.sync(当前激活对象,当存在需要显示提示框的时候需要绑定改属性)
-->
<template>
    <div class="apn">
        <!--头部图标-->
        <div class="icon"><i :class="icon"></i></div>
        <!--密码框眼睛-->
        <div v-if="isPassword" class="icon ipassword" @click="displayPassword=!displayPassword">
            <i v-if="!displayPassword" class="el-icon-view"></i>
            <i v-if="displayPassword" class="el-icon-view noDisplay"></i>
        </div>
        <!--验证码框按钮-->
        <div v-if="isCoder" class="icon coder-div">
            <el-button style="width:90%;" size="small" type="primary" @click="codeClick" :loading="loading"
                :disabled="codeBtnDisabled">{{title}}</el-button>
        </div>
        <input v-model="cuValue" :type="type[displayPassword]" ref="cuInput" :placeholder="placeholder"
            :class="type[isPassword]+' '+coder[isCoder]" @focus="inputFocus" />
        <tip :visible="visible" content="大写已开启"></tip>
    </div>
</template>

<script>
    import tip from './tip'
    export default {
        name: 'iconInput',
        components: {
            tip,
        },
        props: {
            value:{
                type:String,
                default:""
            },
            icon: {
                type:String,
                default:""
            },
            placeholder: {
                type:String,
                default:""
            },
            isPassword: {
                type:Boolean,
                default:false
            },
            isCoder: {
                type:Boolean,
                default:false
            },
            loading:{
                type:Boolean,
                default:false
            },
            title: {
                type:String,
                default:""
            },
            codeBtnDisabled: {
                type:Boolean,
                default:true
            },
            isCaps: {
                type:Boolean,
                default:false
            },
            curFocusCm: null,
        },
        watch: {
            value(newValue) {
                this.cuValue = newValue;
            },
            cuValue(newValue) {
                this.$emit("input", newValue);
            },
            isCaps(newValue) {
                if (newValue && this.isPassword && this.$refs['cuInput'] == this.curFocusCm) {
                    this.visible = true;
                } else {
                    this.visible = false;
                }
            },
            curFocusCm(newValue) {
                if (this.isCaps && this.isPassword && this.$refs['cuInput'] == newValue) {
                    this.visible = true;
                } else {
                    this.visible = false;
                }
            }
        },
        methods: {
            codeClick() {
                this.$emit("codeClick")
            },
            inputFocus() {
                this.$emit("update:curFocusCm", event.target)
            }
        },
        data() {
            return {
                cuValue: this.value,
                displayPassword: this.isPassword,
                type: {
                    true: 'password',
                    false: 'text'
                },
                coder: {
                    true: "coder",
                    false: ""
                },
                visible: false,
            }
        }
    }
</script>

<style lang='css' scoped>
    .apn {
        width: 100%;
        height: 100%;
        display: flex;
        position: relative;
    }

    .icon {
        position: absolute;
        z-index: 1;
        width: 35px;
        height: 38px;
        display: flex;
        align-items: center;
        justify-content: center;
        font-size: 27px;
        color: #a2b8cc;
    }

    .ipassword {
        right: 0;
        font-size: 20px;
        cursor: pointer;
    }

    .ipassword:hover {
        color: #21b9f5;
    }

    .coder-div {
        width: 100px;
        height: 38px;
        right: 0;
    }

    input {
        width: 100%;
        height: 35px;
        font-size: 16px;
        line-height: 1.5em;
        border-radius: 3px;
        border: 1px solid #DCDFE6;
        color: #676868;
        transition: border .3s ease-in-out, background .3s ease-in-out, box-shadow .3s ease-in-out;
        padding-left: 35px;
        position: relative
    }

    .password {
        padding-right: 35px;
        ;
    }

    .coder {
        padding-right: 100px;
        ;
    }

    input:focus {
        outline: 0;
        box-shadow: 0 0 0 2px #cee3f1;
        border-color: #21b9f5;
    }

    .noDisplay {
        text-decoration: line-through;
    }
</style>