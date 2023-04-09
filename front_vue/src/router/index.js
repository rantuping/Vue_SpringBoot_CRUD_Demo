import Vue from 'vue'
import Router from 'vue-router'
Vue.use(Router)

export default new Router({
  routes: [
    //配置根路由，并重定向到主页
    {
      path: '/',
      // name: 'Home',
      redirect: '/index'
    },
    //主页
    {
      path: '/index',
      name: 'Index',
      component: () => import('../components/Index.vue')
    },
    // 用户管理界面
    {
      path: '/users',
      name: 'List',
      component: () => import('../components/user/List.vue')
    },
  ]
})
