// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import ElementUI from 'element-ui';   // 引入element-ui
import axios from 'axios'   //引入axios
import 'element-ui/lib/theme-chalk/index.css';
Vue.use(ElementUI);   // 在Vue中使用ElementUI
Vue.prototype.$axios = axios    //在Vue中使用axios，将vue原型上的异步请求换成axios的 

Vue.config.productionTip = false    // 设置为 false 以阻止 vue 在启动时生成生产提示。

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
