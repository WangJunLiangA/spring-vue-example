/*
 * @Description: 网络请求
 * @Author: JunLiangWang
 * @Date: 2022-02-07 16:45:49
 * @LastEditors: JunLiangWang
 * @LastEditTime: 2022-02-07 18:03:38
 */

//请求成功返回码
const REQUEST_SUCCESS = 200;
//请求失败返回码
const REQUEST_FAILE = 500;

const locales = require.context('./api/', true, /[A-Za-z0-9-_,\s]+\.js$/i)
const api = {
    REQUEST_SUCCESS,
    REQUEST_FAILE,
}
locales.keys().forEach(key => {
    const matched = key.match(/([A-Za-z0-9-_]+)\./i)
    if (matched && matched.length > 1) {
        const locale = matched[1]
        api[locale] = locales(key).default||locales(key)
        console.info(api)
    }
})
export default api