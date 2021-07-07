package org.example.shixun.service;

import org.example.shixun.domain.User;

import java.util.List;

public interface UserService {

    //注册新用户
    public int addUser(String account,String username,String password);

    public User queryUserByAccount(String account);

    public User queryUserByUsername(String username);

    public int updateUser(User user);

    public List<User> queryUserList();

    public String login();
}
