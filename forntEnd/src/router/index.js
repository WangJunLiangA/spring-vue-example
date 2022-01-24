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
      path: '',
      redirect: '/singin'
    },
    {
      name: "singin",
      path: '/singin',
      component: () => import('../views/login/singin.vue'),
      meta: {
        title: '登录',
        isVerify:true,
      }
    },
  ],
  meta: {
    title: "登录",
    isVerify: true
  },
},
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
