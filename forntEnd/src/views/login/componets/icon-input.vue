<!--
 * @Description: 带图标的输入框
 * @Author: JunLiangWang
 * @Date: 2022-01-28 15:14:27
 * @LastEditors: JunLiangWang
 * @LastEditTime: 2022-01-31 21:58:42
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
    <!--输入框-->
    <input
      v-model="cuValue"
      :type="type[displayPassword]"
      :placeholder="placeholder"
      :class="type[isPassword] + ' ' + coder[isCoder]"
      @focus="inputFocus"
      @blur="inputBlur"
    />
    <tip :visible="isFocus&&isCaps&&isPassword" content="大写已开启"></tip>
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
    //v-model值
    value: {
      type: String,
      default: "",
    },
    //图标
    icon: {
      type: String,
      default: "",
    },
    //提示信息
    placeholder: {
      type: String,
      default: "",
    },
    //是否为密码框
    isPassword: {
      type: Boolean,
      default: false,
    },
    //是否为验证码框
    isCoder: {
      type: Boolean,
      default: false,
    },
    //是否正在加载
    loading: {
      type: Boolean,
      default: false,
    },
    //登录按钮标题
    title: {
      type: String,
      default: "",
    },
    //发送验证码按钮是否可用
    codeBtnDisabled: {
      type: Boolean,
      default: true,
    },
    //是否大写
    isCaps: {
      type: Boolean,
      default: false,
    },
  },
  watch: {
    /**
     * @description: 双向绑定v-model实现
     * @author: JunLiangWang
     * @param {*} newValue 更改值
     * @return {*}
     */
    value(newValue) {
      this.cuValue = newValue;
    },
    /**
     * @description: 双向绑定v-model实现
     * @author: JunLiangWang
     * @param {*} newValue 更改值
     * @return {*}
     */
    cuValue(newValue) {
      this.$emit("input", newValue);
    },
  },
  methods: {
    /**
     * @description: 验证码按钮点击
     * @author: JunLiangWang
     * @param {*}
     * @return {*}
     */
    codeClick() {
      this.$emit("codeClick");
    },
    /**
     * @description: 输入框聚焦，开启大写显示提示框
     * @author: JunLiangWang
     * @param {*}
     * @return {*}
     */
    inputFocus() {
        this.isFocus = true;
    },
    /**
     * @description: 输入框失去焦点，隐藏大写提示框
     * @author: JunLiangWang
     * @param {*}
     * @return {*}
     */
    inputBlur() {
      this.isFocus = false;
    },
  },
  data() {
    return {
      //v-model实现值
      cuValue: this.value,
      //是否为密码
      displayPassword: this.isPassword,
      //输入框类型
      type: {
        true: "password",
        false: "text",
      },
      //是否为验证码模式
      coder: {
        true: "coder",
        false: "",
      },
      //是否焦点
      isFocus:false,
    };
  },
};
</script>

<style lang='scss' scoped>
.apn {
  width: 100%;
  position: relative;
  margin-top: 20px;
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
.iconfont {
  font-size: 21px;
}
.ipassword {
  right: 0;
  font-size: 20px;
  cursor: pointer;
}

.ipassword:hover .iconfont {
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
input:focus + .icon > i {
  color: #68bd45;
}
.noDisplay {
  text-decoration: line-through;
}
</style>