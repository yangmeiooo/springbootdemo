package com.example.demo.service;

import com.example.demo.domain.User;

import java.security.NoSuchAlgorithmException;

public interface UserService {

public User getUser(long id);

public User login(String name,String pass) throws NoSuchAlgorithmException;



}
