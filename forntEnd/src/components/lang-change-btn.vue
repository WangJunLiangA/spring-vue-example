<!--
 * @Description:切换语言按钮 
 * @Author: JunLiangWang
 * @Date: 2022-01-28 10:43:47
 * @LastEditors: JunLiangWang
 * @LastEditTime: 2022-01-28 12:31:49
-->
<template>
  <el-dropdown trigger="click" @command="handleCommand">
    <div class="lanbtn"><span>{{ languageList[currentLanguage].displayTitle }}</span></div>
    <template #dropdown>
      <el-dropdown-menu>
      <el-dropdown-item
        v-for="(val, key, i) in languageList"
        :key="i"
        :command="key"
        >{{ val.itemTitle }}</el-dropdown-item
      >
      </el-dropdown-menu>
    </template>
  </el-dropdown>
</template>

<script>
export default {
  name: "lang-change-btn",
  props: {
    //语言列表
    languageList: {
      type: Object,
      default: () => {
        return {
          //语言Key,与i8n中的key对应
          zh: {
            itemTitle: "简体中文", //列表选项中显示的标题
            displayTitle: "简", //选中后按钮显示的值
          },
          en: {
            itemTitle: "English",
            displayTitle: "EN",
          },
        };
      },
    },
    //当前选中的语言的Key
    currentLanguage: {
      type: String,
      default: "zh",
    },
  },
  methods: {
    /**
     * @description: 切换语言时间
     * @author: JunLiangWang
     * @param {*} command 语言key
     * @return {*}
     */    
    handleCommand(command) {
      this.$emit("changeCommand", command);
    },
  },
};
</script>

<style scoped>
.lanbtn {
    cursor: pointer;
    padding: 6px 6px;
    border-radius: 3px;
    font-size: 17px;
    background: #68bd45;
}
.lanbtn>span{
    color: white;
}
.lanbtn:hover {
  background: #34495e;
}
</style>