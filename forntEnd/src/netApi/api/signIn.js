/*
 * @Description: 登录页面网络请求
 * @Author: JunLiangWang
 * @Date: 2022-02-07 16:53:08
 * @LastEditors: JunLiangWang
 * @LastEditTime: 2022-02-07 17:28:20
 */
import api from '../initApi'

export default {
    /*获取验证码接口*/
    getCaptcha_api: function () {
        return api.Get("/captcha/getCaptcha")
    },
}