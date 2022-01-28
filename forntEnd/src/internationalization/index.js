/*
 * @Description:国际化配置文件 
 * @Author: JunLiangWang
 * @Date: 2022-01-28 10:42:22
 * @LastEditors: JunLiangWang
 * @LastEditTime: 2022-01-28 11:41:17
 */
import {createI18n} from 'vue-i18n'

/**
 * @description: 获取当前文件夹下json国际化文件
 * @author: JunLiangWang
 * @param {*}
 * @return {*}
 */
function loadLocaleMessages () {
  const locales = require.context('./language/', true, /[A-Za-z0-9-_,\s]+\.json$/i)
  const messages = {}
  locales.keys().forEach(key => {
    const matched = key.match(/([A-Za-z0-9-_]+)\./i)
    if (matched && matched.length > 1) {
      const locale = matched[1]
      messages[locale] = locales(key)
      console.info(messages)
    }
  })
  return messages
}

//判断是否已经选择过语言
var language=localStorage.getItem("language")
if(language==null)
{
  language='zh'
  localStorage.setItem("language",'zh')
}

//国际化配置
const i18nConfig ={
  locale:language,
  fallbackLocale:  'zh',
  messages: loadLocaleMessages()
}

export default function setI18n(vue)
{
  const i18n=createI18n(i18nConfig);
  vue.use(i18n);
}