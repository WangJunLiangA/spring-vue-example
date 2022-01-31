<!--带图标的文本框
    普通文本框   v-model,icon,placeholder,curFocusCm.sync(当前激活对象,当存在需要显示提示框的时候需要绑定改属性)
    密码框       以上,isPassword=true,isCaps(是否大写),curFocusCm.sync(当前激活对象,当存在需要显示提示框的时候需要绑定改属性)
    验证码框     普通文本框，isCoder,loading,title,@coderClick,codeBtnDisabled,curFocusCm.sync(当前激活对象,当存在需要显示提示框的时候需要绑定改属性)
-->
<template>
  <div class="apn">
    <!--验证码框按钮-->
    <div v-if="isCoder" class="icon coder-div">
      <el-button
        style="width: 90%"
        size="small"
        type="primary"
        @click="codeClick"
        :loading="loading"
        :disabled="codeBtnDisabled"
        >{{ title }}</el-button
      >
    </div>
    <input
      v-model="cuValue"
      :type="type[displayPassword]"
      ref="cuInput"
      :placeholder="placeholder"
      :class="type[isPassword] + ' ' + coder[isCoder]"
      @focus="inputFocus"
    />
    <tip :visible="visible" content="大写已开启"></tip>
    <!--头部图标-->
    <div class="icon"><i :class="icon"></i></div>
    <!--密码框眼睛-->
    <div
      v-if="isPassword"
      class="icon ipassword"
      @click="displayPassword = !displayPassword"
    >
      <i v-if="!displayPassword" class="iconfont icon-Show"></i>
      <i v-if="displayPassword" class="iconfont icon-Hide"></i>
    </div>
  </div>
</template>

<script>
import tip from "./tip";
export default {
  name: "iconInput",
  components: {
    tip,
  },
  props: {
    value: {
      type: String,
      default: "",
    },
    icon: {
      type: String,
      default: "",
    },
    placeholder: {
      type: String,
      default: "",
    },
    isPassword: {
      type: Boolean,
      default: false,
    },
    isCoder: {
      type: Boolean,
      default: false,
    },
    loading: {
      type: Boolean,
      default: false,
    },
    title: {
      type: String,
      default: "",
    },
    codeBtnDisabled: {
      type: Boolean,
      default: true,
    },
    isCaps: {
      type: Boolean,
      default: false,
    },
    isMust:{
      type: Boolean,
      default: true,
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
      if (
        newValue &&
        this.isPassword &&
        this.$refs["cuInput"] == this.curFocusCm
      ) {
        this.visible = true;
      } else {
        this.visible = false;
      }
    },
    curFocusCm(newValue) {
      if (this.isCaps && this.isPassword && this.$refs["cuInput"] == newValue) {
        this.visible = true;
      } else {
        this.visible = false;
      }
    },
  },
  methods: {
    codeClick() {
      this.$emit("codeClick");
    },
    inputFocus() {
      this.$emit("update:curFocusCm", event.target);
    },
  },
  data() {
    return {
      cuValue: this.value,
      displayPassword: this.isPassword,
      type: {
        true: "password",
        false: "text",
      },
      coder: {
        true: "coder",
        false: "",
      },
      visible: false,
    };
  },
};
</script>

<style lang='scss' scoped>
.apn {
    width: 100%;
    position: relative;
    margin-top:20px;
}

.icon {
  position: absolute;
  width: 35px;
  display: flex;
  align-items: center;
  justify-content: center;
  font-size: 27px;
  top: 0;
  bottom: 0;
}
.iconfont{
    font-size: 21px;
}
.ipassword {
  right: 0;
  font-size: 20px;
  cursor: pointer;
}

.ipassword:hover .iconfont{
  color: #68bd45;
}

.coder-div {
  width: 100px;
  height: 38px;
  right: 0;
}

input {
  width: 100%;
  height: 45px;
  font-size: 16px;
  border-radius: 3px;
  border: 2px solid #f4f4f4;
  background: #354a5f0a;
  color: #676868;
  transition: border 0.3s ease-in-out, background 0.3s ease-in-out,
    box-shadow 0.3s ease-in-out;
  padding-left: 35px;
  box-sizing: border-box;
}
.password {
  padding-right: 35px;
}

.coder {
  padding-right: 100px;
}

input:focus {
  outline: 0;
  border-color: #69bd464f;
}
input:focus+.icon>i{
  color: #68bd45;
}
.noDisplay {
  text-decoration: line-through;
}
</style>