<!--
 * @Description: 登录页面
 * @Author: JunLiangWang
 * @Date: 2022-01-27 16:23:31
 * @LastEditors: JunLiangWang
 * @LastEditTime: 2022-02-01 16:46:13
-->
<template>
  <div class="container">
    <!--头部-->
    <div class="header">
      <!--切换语言按钮-->
      <lang-change-btn
        :languageList="languageList"
        :currentLanguage="$i18n.locale"
        @changeCommand="handleCommand"
      ></lang-change-btn>
    </div>
    <!--标题-->
    <div class="item">
      <log-title title="欢迎登录" subTitle="welcome to login"></log-title>
    </div>
    <!--输入框-->
    <div class="item">
      <icon-input
        icon="iconfont icon-zhanghu"
        :placeholder="language.accountInputPlaceholder"
      ></icon-input>
      <icon-input
        icon="iconfont icon-mima"
        :isPassword="true"
        :placeholder="language.passwordInputPlaceholder"
        :isCaps="isCaps"
      ></icon-input>
    </div>
    <!--选择框-->
    <div class="item three-container">
      <circle-checkbox
        :title="language.maintainLogin"
        v-model="isMaintain"
      ></circle-checkbox>
      <a>{{ language.forgetPassword }}</a>
    </div>
    <!--登录按钮-->
    <div class="item three-container firth">
      <div class="logbtn-div">
        <log-btn :title="language.loginBtn"></log-btn>
      </div>
      <span class="loginup-span"
        >{{ language.haveNotAccount }}<a>{{ language.signUp }}</a></span
      >
    </div>
  </div>
</template>

<script>
import langChangeBtn from "@/components/lang-change-btn.vue";
import logTitle from "../componets/log-title.vue";
import iconInput from "../componets/icon-input.vue";
import circleCheckbox from "@/components/circle-checkbox";
import logBtn from "../componets/log-btn.vue";
export default {
  name: "signIn",
  components: {
    langChangeBtn,
    logTitle,
    iconInput,
    circleCheckbox,
    logBtn,
  },
  data() {
    return {
      //语言列表
      languageList: {
        //语言Key,与i8n中的key对应
        zh: {
          itemTitle: "简体中文", //列表选项中显示的标题
          displayTitle: "简", //选中后按钮显示的值
        },
        en: {
          itemTitle: "English",
          displayTitle: "EN",
        },
      },
      //是否大写
      isCaps: false,
      //是否保持登录
      isMaintain: false,
    };
  },
  computed: {
    language() {
      var pre = "login";
      return {
        accountInputPlaceholder: this.$t(pre + ".accountInputPlaceholder"),
        passwordInputPlaceholder: this.$t(pre + ".passwordInputPlaceholder"),
        forgetPassword: this.$t(pre + ".forgetPassword"),
        maintainLogin: this.$t(pre + ".maintainLogin"),
        loginBtn: this.$t(pre + ".loginBtn"),
        haveNotAccount: this.$t(pre + ".haveNotAccount"),
        signUp: this.$t(pre + ".signUp"),
      };
    },
  },
  methods: {
    /**
     * @description: 更改语言
     * @author: JunLiangWang
     * @param {*} command 语言key
     * @return {*}
     */
    handleCommand(command) {
      this.$i18n.locale = command;
      localStorage.setItem("language", command);
    },
  },
  mounted() {
    /*回车快捷键*/
    var that = this;
    document.onkeydown = function () {
      that.isCaps = window.event.getModifierState("CapsLock");
    };
  },
};
</script>

<style lang="scss" scoped>
.container {
  padding: 10px;
  box-sizing: border-box;
  width: 100%;
  height: 100%;
}
img {
  width: 35px;
  height: 35px;
}
.logo-div {
  display: flex;
  flex-direction: row;
  align-items: center;
  font-size: 19px;
  font-weight: bold;
}
.header {
  text-align: end;
}
.item {
  width: 100%;
  padding: 20px 40px;
  box-sizing: border-box;
}
p {
  margin-bottom: 4px;
  color: #c9d0d9;
  margin-top: 0;
}
.three-container {
  padding-top: 0;
  font-size: 13px;
  font-weight: bold;
  display: flex;
  flex-wrap: nowrap;
  justify-content: space-between;
  align-items: center;
  a {
    color: #b7bdc4;
    cursor: pointer;
    font-weight: normal;
  }
  a:hover {
    color: #34495e;
  }
}
.firth {
  padding-top: 20px;
}
.logbtn-div {
  height: 40px;
  width: 40%;
  font-size: 18px;
}
.loginup-span {
  color: #c1c5cc;
  margin-left: 20px;
  font-weight: normal;
  a {
    color: #69bd46;
    cursor: pointer;
  }
}
</style>
