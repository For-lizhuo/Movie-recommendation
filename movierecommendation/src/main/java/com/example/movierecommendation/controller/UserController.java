package com.example.movierecommendation.controller;

import com.example.movierecommendation.mapper.UserMapper;
import com.example.movierecommendation.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/queryUserList")
    public List queryUserList(){
        List<User> userList=userMapper.queryUserList();
        for(User user:userList){
            System.out.println(user);
        }
        return userList;
    }

    @GetMapping("/queryUserById")
    public String queryUserById(){
        return userMapper.queryUserById(2).getUsername();
    }

    @GetMapping("/addUser")
    public String addUser(){
        userMapper.addUser(new User(5,"amao","4567"));
        return "ok";
    }

    @GetMapping("/updateUser")
    public String updateUser(){
        userMapper.updateUser(new User(5,"amao","45678"));
        return "ok";
    }

    @GetMapping("/deleteUser")
    public String deleteUser(){
        userMapper.deleteUser(5);
        return "ok";
    }

}
