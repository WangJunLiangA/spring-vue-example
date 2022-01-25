import { createApp } from 'vue'
import App from './App.vue'
import './registerServiceWorker'
import router from './router'
import store from './store'

const Vue=createApp(App)


//初始化样式
import './assets/css/normalize.css'

//工具类，挂载到vue全局
import until from './until'
Vue.config.globalProperties.$until = until

/* 手机浏览器控制台
 npm install vconsole
*/
 import Vconsole from 'vconsole';
 if(process.env.NODE_ENV != 'production'&&until.isMobile())
 {
    new Vconsole();
 }
 

Vue.use(store).use(router).mount('#app')
