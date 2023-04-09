package com.tu.controller;

import com.alibaba.druid.util.StringUtils;
import com.tu.entity.User;
import com.tu.service.UserService;
import com.tu.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author rantuping
 * @date 2023/4/7 11:50
 */
@RestController
@CrossOrigin  //允许跨域，前端8080，后端8989
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/findAll")
    public List<User> findAll() {
        return userService.findAll();
    }

    //保存或修改
    @PostMapping("/saveOrUpdate")
    public Result saveOrUpdate(@RequestBody User user) {
        Result result = new Result();
        try {
            if (StringUtils.isEmpty(user.getId())){
                userService.save(user);
                result.setMsg("保存用户信息成功...");
            }else {
                userService.update(user);
                result.setMsg("修改用户信息成功...");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.setStatus(false);
            result.setMsg("保存或保存失败,请稍后再试");
        }
        return result;
    }

    @GetMapping("/delete")
    public Result delete(String id) {
        Result result = new Result();
        try {
            userService.delete(id);
            result.setMsg("删除用户信息成功...");
        } catch (Exception e) {
            e.printStackTrace();
            result.setStatus(false);
            result.setMsg("删除失败,请稍后再试");
        }
        return result;
    }

     //分页查询
    @GetMapping("/findByPage")
    public Map<String,Object> findByPage(Integer pageNow,Integer pageSize){
        Map<String,Object> result = new HashMap<>();
        pageNow = pageNow == null ? 1 : pageNow;
        pageSize = pageSize == null ? 5 : pageSize;
        List<User> users = userService.findByPage(pageNow, pageSize);
        Long totals = userService.findTotals();
        result.put("users",users);
        result.put("total",totals);
        return result;
    }
}
