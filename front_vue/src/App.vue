<template>
  <div id="app">
    <!-- <img src="./assets/logo.png"> -->
    <!-- <router-view/> -->
    <el-container>
      <el-header>
        <!-- 导航菜单 -->
        <el-menu
          :default-active="activeIndex"
          class="el-menu-demo"
          mode="horizontal"
          @select="handleSelect"
        >
          <el-menu-item index="/index">主页</el-menu-item>
          <el-menu-item index="/users">用户管理</el-menu-item>
          <el-menu-item index="/msgs">消息中心</el-menu-item>
          <el-menu-item index="/orders">订单管理</el-menu-item>
        </el-menu>
      </el-header>

      <el-main>
        <!-- 路由组件 -->
        <router-view />
      </el-main>
    </el-container>
  </div>
</template>

<script>
export default {
  name: "App",
  data() {
    return {
      activeIndex: this.$route.path, 
    };
  },
  methods: {
    // 菜单项被选中时触发
    handleSelect(key, keyPath) {
      //传递的参数就是对应路由的path，那就可以直接在这里做路由切换
      this.$router.push(key);
    },
  },
};
</script>

<style>
#app {

}
</style>
