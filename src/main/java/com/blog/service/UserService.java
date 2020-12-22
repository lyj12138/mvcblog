package com.blog.service;

import com.blog.domain.User;

import java.util.List;

public interface  UserService {
    User getById(Integer id);

    User getByEmail(String email);

    User getByUserName(String username);

    void insertSelective(User user);

    List<User> selectByState(String state);

    List<User> queryAll();

    boolean updateByPrimaryKey(User user);

    int deleteById(int id);
}
