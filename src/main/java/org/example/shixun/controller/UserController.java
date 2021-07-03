package org.example.shixun.controller;

import org.example.shixun.entity.User;
import org.example.shixun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//@Controller
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = {"userList"})
    public List<User> getUser()
    {
        return userService.queryUserList();
    }

    @RequestMapping(value = {"/getUser"}, method = RequestMethod.POST)
    public User getUser(@RequestParam(value = "username") String username)
    {
        return userService.queryUserByUsername(username);
    }

    @RequestMapping(value = {"/login"}, method = RequestMethod.POST)
    public String login(@RequestParam(value = "account") String account,
                        @RequestParam(value = "password") String password) {
        User user=userService.queryUserByAccount(account);
        if(user==null) {
            return "account doesn't exist";
        }
        else if(!user.getPassword().equals(password)) {
            return "password error";
        }
        else
            return "login success";
    }

    @RequestMapping("/register")
    public String register(@RequestParam(value = "account") String account,
                           @RequestParam(value = "username") String username,
                           @RequestParam(value = "password") String password,
                           @RequestParam(value = "password2") String password2) {
        if (!password.equals(password2)) {
            return "password error";
        } else if(userService.queryUserByUsername(username)==null) {
            int res = userService.addUser(account,username, password);
            return "register success";
        }
        return "account has existed";
    }

    @RequestMapping("/updateUser")
    public String updateUser(@RequestBody User user) {
        userService.updateUser(user);
        return "success";
    }
}
