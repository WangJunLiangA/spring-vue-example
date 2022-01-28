<!--
 * @Description: 登录页面
 * @Author: JunLiangWang
 * @Date: 2022-01-27 16:23:31
 * @LastEditors: JunLiangWang
 * @LastEditTime: 2022-01-28 11:39:07
-->
<template>
  <div class="container">
    <div>
      <img src="@/assets/img/icon.png" />
      <lang-change-btn
         :languageList="languageList"
        :currentLanguage="$i18n.locale"
        @changeCommand="handleCommand"
      ></lang-change-btn>
    </div>
    <div>
      {{$t("login.test")}}
    </div>
  </div>
</template>

<script>
import langChangeBtn from "@/components/lang-change-btn.vue";
export default {
  name: "signIn",
  components: {
    langChangeBtn,
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
    };
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
      localStorage.setItem("language",command);
    },
  },
};
</script>

<style scoped>
.container {
  padding: 10px;
  box-sizing: border-box;
  width: 100%;
  height: 100%;
}
img {
  width: 30px;
  height: 30px;
}
.logo-div {
  display: flex;
  flex-direction: row;
  align-items: center;
  font-size: 19px;
  font-weight: bold;
}
</style>
