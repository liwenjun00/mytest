package com.liwenjun.mytest.dao;


import com.liwenjun.mytest.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {


    User getUserById(Long id);

    List<User> listUsers();


}
