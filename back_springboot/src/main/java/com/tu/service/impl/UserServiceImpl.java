package com.tu.service.impl;

import com.tu.dao.UserDAO;
import com.tu.entity.User;
import com.tu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author rantuping
 * @date 2023/4/7 11:46
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    //查询所有用户信息
    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }

    //新增用户信息
    @Override
    public void save(User user) {
        userDAO.save(user);
    }

    //删除用户信息
    @Override
    public void delete(String id) {
        userDAO.delete(id);
    }

    //修改用户信息
    @Override
    public void update(User user) {
        userDAO.update(user);
    }

    //分页查询（业务方法不需要做任何的参数绑定 ）
    @Override
    public List<User> findByPage(Integer pageNow, Integer rows) {
        //计算起始条数
        Integer start = (pageNow - 1) * rows;
        return userDAO.findByPage(start, rows);
    }

    //查询总条数
    @Override
    public Long findTotals() {
        return userDAO.findTotals();
    }
}
