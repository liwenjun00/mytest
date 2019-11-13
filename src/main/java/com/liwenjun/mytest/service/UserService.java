package com.liwenjun.mytest.service;

import com.liwenjun.mytest.model.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserService {


    User getUserById(Long id);

    List<User> listUsers();
}
