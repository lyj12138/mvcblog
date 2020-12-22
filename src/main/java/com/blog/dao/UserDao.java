package com.blog.dao;

import com.blog.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    User selectByPrimaryKey(Integer id);

   User getByEmail(String email);

    User getByUserName(String username);

    void insertSelective(User user);

    List<User> selectByState(String state);

    List<User> queryAll();

    boolean updateByPrimaryKey(User user);

    int deleteByPrimaryKey(Integer id);
}
