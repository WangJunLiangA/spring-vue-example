import { createApp } from 'vue'
import App from './App.vue'
import './registerServiceWorker'
import router from './router'
import store from './store'

const Vue=createApp(App)

//初始化样式
import './assets/css/normalize.css'

//elemntuiPlus
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
Vue.use(ElementPlus)

Vue.use(store).use(router).mount('#app')
