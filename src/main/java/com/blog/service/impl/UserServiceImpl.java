package com.blog.service.impl;

import com.blog.dao.UserDao;
import com.blog.domain.User;
import com.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    public UserDao userDao;
    @Override
    public User getById(Integer id) {
        return userDao.selectByPrimaryKey(id);
    }

    @Override
    public User getByEmail(String email) {
        return userDao.getByEmail(email);
    }

    @Override
    public User getByUserName(String username) {
        return userDao.getByUserName(username);
    }

    @Override
    public void insertSelective(User user) {
        userDao.insertSelective(user);
    }

    @Override
    public List<User> selectByState(String state) {
        return userDao.selectByState(state);
    }

    @Override
    public List<User> queryAll() {
        return userDao.queryAll();
    }

    @Override
    public boolean updateByPrimaryKey(User user) {
        return userDao.updateByPrimaryKey(user);
    }

    @Override
    public int deleteById(int id) {
        return userDao.deleteByPrimaryKey(id);
    }
}
