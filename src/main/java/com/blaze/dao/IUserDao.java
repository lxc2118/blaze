package com.blaze.dao;

import java.util.List;

import com.blaze.biz.User;

public interface IUserDao {
	
    void save(User user);
    
    void update(User user);
	
    void del(Integer id);

    User findById(Integer id);

    List<User> findAll();
}