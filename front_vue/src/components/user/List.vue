<template>
  <div>
    <el-table
      
      :data="
        tableData.filter(
          (data) =>
            !search || data.name.toLowerCase().includes(search.toLowerCase())
        )
      "
      style="width: 100%"
    >
      <el-table-column label="编号" width="180" prop="id"></el-table-column>
      <el-table-column label="姓名" width="180" prop="name"></el-table-column>
      <el-table-column label="性别" prop="sex"></el-table-column>
      <el-table-column label="生日" prop="bir"></el-table-column>
      <el-table-column label="住址" prop="address"></el-table-column>

      <el-table-column align="right">
        <template slot="header" slot-scope="scope">
          <el-input
            v-model="search"
            size="mini"
            placeholder="输入姓名的关键字搜索"
          />
        </template>
        <template slot-scope="scope">
          <el-button size="mini" @click="handleEdit(scope.$index, scope.row)"
            >编辑</el-button
          >

          <el-popconfirm
            confirm-button-text="确定"
            cancel-button-text="取消"
            icon="el-icon-info"
            icon-color="red"
            title="确定删除当前用户吗?"
            @confirm="handleDelete(scope.$index, scope.row)"
          >
            <el-button size="mini" type="danger" slot="reference"
              >删除</el-button
            >
          </el-popconfirm>
        </template>
      </el-table-column>
    </el-table>

    <el-row>
      <el-col :span="12" :offset="12">
        <div class="grid-content bg-purple">
          <!-- 分页组件  -->
          <el-pagination 
          layout="prev, pager, next, jumper, total, sizes" 
          :total=total
          :page-size="size"
          :current-page = "pageNow"
          :page-sizes="[5,10,15,20,50]"
          prev-text="上一页"
          next-text="下一页"
          background
          small
          @current-page="findPage"
          @size-change="findSize"
          >
          </el-pagination></div>
        </el-col>
    </el-row>

    <el-button
      style="margin: 15px, 0px"
      size="mini"
      type="success"
      @click="saveUserInfo()"
      >添加</el-button
    >
    <transition name="el-zoom-in-center">
      <div v-show="show" class="transition-box">
        <el-form ref="form" :model="form" label-suffix=":" label-width="80px">
          <el-form-item label="姓名">
            <el-input v-model="form.name"></el-input>
          </el-form-item>
          <el-form-item label="生日">
            <el-date-picker
              type="date"
              placeholder="选择日期"
              v-model="form.bir"
              style="width: 100%"
            ></el-date-picker>
          </el-form-item>
          <el-form-item label="性别">
            <el-radio-group v-model="form.sex">
              <el-radio label="男"></el-radio>
              <el-radio label="女"></el-radio>
            </el-radio-group>
          </el-form-item>
          <el-form-item label="详细地址">
            <el-input type="textarea" v-model="form.address"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="onSubmit">提交</el-button>
            <el-button @click="saveUserInfo">重置</el-button>
          </el-form-item>
        </el-form>
      </div>
    </transition>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "List",
  data() {
    return {
      tableData: [],
      search: "",
      show: true,
      form: {
        name: "",
        sex: "男",
        bir: "",
        address: "",
      },
      total:0,
      size:5,
      pageNow:1,
    };
  },
  methods: {
    findSize(size){//用来处理每页显示多少条数据的方法
      console.log();
    },
    findPage(){ //用来处理分页的相关方法
      this.findALLUserData(pageNow,this.size);
    },
    findALLUserData(page,size) {
      page = page ? page:this.pageNow;
      size = size ?  size:this.size;
      axios.get("http://localhost:8989/user/findByPage?pageNow"+page+"&pageSize"+size).then((res) => {
        this.tableData = res.data.users;
        this.total = res.data.total;
      });
    },
    //编辑
    handleEdit(index, row) {
      this.show = true; //显示表单
      this.form = row; //将当前行的数据赋值给表单
    },
    //删除
    handleDelete(index, row) {
      //发送请求到后台
      axios
        .get("http://localhost:8989/user/delete?id=" + row.id)
        .then((res) => {
          if (res.data.status) {
            //显示成功提示
            this.$message({
              message: res.data.msg,
              type: "success",
            });
            //重新加载数据
            this.findALLUserData();
          } else {
            this.$message.error(res.data.msg);
          }
        });
    },
    //添加
    saveUserInfo() {
      //显示表单，并清空表单信息
      this.show = true;
      this.form = { sex: "男" };
    },
    onSubmit() {
      //点击提交按钮，发送请求到后台
      axios
        .post("http://localhost:8989/user/saveOrUpdate", this.form)
        .then((res) => {
          if (res.data.status) {
            //显示成功提示
            this.$message({
              message: res.data.msg,
              type: "success",
            });
            //清空表单信息
            this.form = { sex: "男" };
            //隐藏表单
            this.show = false;
            //重新加载数据
            this.findALLUserData();
          } else {
            this.$message.error(res.data.msg);
          }
        });
    },
    onConcel() {
      //清空表单信息
      this.form = { sex: "男" };
      this.show = false;
    },
  },
  created() {
    this.findALLUserData();
  },
};
</script>



<style scoped>
.transition-box {
  margin-bottom: 10px;
  width: 60%;
  height: 600px;
  border-radius: 4px;
  /* background-color: #409EFF; */
  /* text-align: center; */
  /* color: #fff; */
  padding: 40px 20px;
  box-sizing: border-box;
  margin-right: 20px;
}
</style>