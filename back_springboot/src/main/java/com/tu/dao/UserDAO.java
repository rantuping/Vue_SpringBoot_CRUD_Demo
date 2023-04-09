package com.tu.dao;

import com.tu.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author rantuping
 * @date 2023/4/7 11:40
 */
@Mapper
public interface UserDAO {
    //查询所有用户信息
    List<User> findAll();

    //新增用户信息
    void save(User user);

    //删除用户信息
    void delete(String id);

    //修改用户信息
    void update(User user);

    //分页查询
    List<User> findByPage(@Param("start") Integer start,@Param("rows")  Integer rows);

    //查询总条数
    Long findTotals();
}
