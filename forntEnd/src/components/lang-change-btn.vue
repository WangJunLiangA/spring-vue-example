<!--
 * @Description:切换语言按钮 
 * @Author: JunLiangWang
 * @Date: 2022-01-28 10:43:47
 * @LastEditors: JunLiangWang
 * @LastEditTime: 2022-01-28 11:40:32
-->
<template>
  <el-dropdown trigger="click" @command="handleCommand">
    <span class="lanbtn">{{ languageList[currentLanguage].displayTitle }}</span>
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
  padding: 4px 2px;
  border-radius: 3px;
}
.lanbtn:hover {
  background: #90909042;
}
</style>