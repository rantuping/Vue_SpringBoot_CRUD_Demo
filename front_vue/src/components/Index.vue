<template>
  <div>
    <!-- 主页展示轮播图 -->
    <el-carousel :interval="4000" type="card" height="500px">
      <el-carousel-item v-for="item in imgs" :key="item">
        <!-- 这里展示不用标题，而应该用elementUI中的图片 -->
        <!-- <h3 class="medium">{{ item }}</h3> -->
        <el-image
          :src="item"
          fit="fill"
        ></el-image>
      </el-carousel-item>
    </el-carousel>
    <!-- 其它信息 -->
    <h1>还可以放其它内容</h1>
  </div>
</template>

<script>
//导入图片
import homeImg1 from "../assets/IndexImgs/1.jpg";
import homeImg2 from "../assets/IndexImgs/2.jpg";
import homeImg3 from "../assets/IndexImgs/3.jpg";
import homeImg4 from "../assets/IndexImgs/4.jpg";
import homeImg5 from "../assets/IndexImgs/5.jpg";
import homeImg6 from "../assets/IndexImgs/6.jpg";
import homeImg7 from "../assets/IndexImgs/7.jpg";
import homeImg8 from "../assets/IndexImgs/8.jpg";
export default {
  name: "Index",
  data() {
    return {
      //创建图片数组，让上面的轮播图可以循环显示
      imgs: [
        homeImg1,
        homeImg2,
        homeImg3,
        homeImg4,
        homeImg5,
        homeImg6,
        homeImg7,
        homeImg8,
      ],
    };
  },
};
</script>

<style>
/* .el-carousel__item h3 {
  color: #475669;
  font-size: 14px;
  opacity: 0.75;
  line-height: 300px;
  margin: 0;
}

.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n + 1) {
  background-color: #d3dce6;
} */
</style>