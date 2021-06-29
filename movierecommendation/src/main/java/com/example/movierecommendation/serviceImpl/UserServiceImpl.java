package com.example.movierecommendation.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.movierecommendation.mapper.UserMapper;
import com.example.movierecommendation.pojo.User;
import com.example.movierecommendation.service.UserService;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper usermapper;

    //注册新用户
    @Override
    public int addUser(String username, String password) {
        return usermapper.addUser(username,password);
    }

    @Override
    public User queryUserByUsername(String username) {
        return usermapper.queryUserByUsername(username);
    }

    public List<User> queryUserList(){
        return usermapper.queryUserList();
    };
}
