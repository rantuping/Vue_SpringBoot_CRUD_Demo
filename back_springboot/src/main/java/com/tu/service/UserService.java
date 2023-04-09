package com.tu.service;

import com.tu.entity.User;

import java.util.List;

/**
 * @author rantuping
 * @date 2023/4/7 11:45
 */
public interface UserService {
    //查询所有用户信息
    List<User> findAll();

    //新增用户信息
    void save(User user);

    //删除用户信息
    void delete(String id);

    //修改用户信息
    void update(User user);

    //分页查询（业务方法不需要做任何的参数绑定,这里接受前端传递来的参数 ）
    List<User> findByPage(Integer pageNow,Integer rows);

    //查询总条数
    Long findTotals();
}
