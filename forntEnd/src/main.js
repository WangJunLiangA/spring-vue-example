import { createApp } from 'vue'
import App from './App.vue'
import './registerServiceWorker'
import router from './router'
import store from './store'

const Vue=createApp(App)


//ElementUI
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
Vue.use(ElementPlus);

//国际化
import setI18n from './internationalization'
setI18n(Vue)

//初始化样式
import './assets/css/normalize.css'
//全局样式
import './assets/css/command.css'

//工具类，挂载到vue全局
import until from './until'
Vue.config.globalProperties.$until = until

//网络请求，挂载到vue全局
import netApi from './netApi/index'
Vue.config.globalProperties.$netApi = netApi

//全局挂载message弹出工具
import msg from './until/message.js'
Vue.config.globalProperties.$msg = msg

/* 手机浏览器控制台
 npm install vconsole
*/
 import Vconsole from 'vconsole';
 if(process.env.NODE_ENV != 'production'&&until.isMobile())
 {
    new Vconsole();
 }
 

Vue.use(store).use(router).mount('#app')
