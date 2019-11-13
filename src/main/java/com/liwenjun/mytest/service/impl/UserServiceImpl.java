package com.liwenjun.mytest.service.impl;

import com.liwenjun.mytest.dao.UserMapper;
import com.liwenjun.mytest.model.User;
import com.liwenjun.mytest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;


    @Override
    public User getUserById(Long id) {
        return userMapper.getUserById(id);
    }

    @Override
    public List<User> listUsers() {
        return userMapper.listUsers();
    }
}
