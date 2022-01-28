/*
 * @Description:路由地址 
 * @Author: JunLiangWang
 * @Date: 2022-01-20 10:45:46
 * @LastEditors: JunLiangWang
 * @LastEditTime: 2022-01-27 17:18:52
 */
import { createRouter, createWebHistory } from 'vue-router'

const routes = [{
  path: "",
  redirect: '/login'
},
{
  //登录路由
  name: "login",
  path: "/login",
  component: () => import('../views/login/login.vue'),
  children:[
    {
        path: "",
        redirect: '/signin'
    },
    {
      //登录路由
      name: "signin",
      path: "/signin",
      component: () => import('../views/login/views/sign-in.vue'),
    },
    {
      //注册路由
      name: "signup",
      path: "/signup",
      component: () => import('../views/login/views/sign-up.vue'),
    },
    {
      //忘记密码
      name: "forgetpassword",
      path: "/forgetpassword",
      component: () => import('../views/login/views/forget-password.vue'),
    }
  ]
},
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
