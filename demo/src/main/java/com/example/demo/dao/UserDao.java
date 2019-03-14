package com.example.demo.dao;

import com.example.demo.domain.User;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface UserDao {


    public User getUser(long id);


    public User login(@Param("name") String name,@Param("pass") String pass);


    public List<User> userSalt();
}
