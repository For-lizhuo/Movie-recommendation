package com.example.movierecommendation.service;

import com.example.movierecommendation.pojo.User;

import java.util.List;

public interface UserService {
    //注册新用户
    public int addUser(String account,String username,String password);

    public User queryUserByAccount(String account);

    public User queryUserByUsername(String username);

    public List<User> queryUserList();

}
