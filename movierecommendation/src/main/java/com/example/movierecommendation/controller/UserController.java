package com.example.movierecommendation.controller;

import com.example.movierecommendation.mapper.UserMapper;
import com.example.movierecommendation.pojo.User;
import com.example.movierecommendation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

//@Controller
@RestController
@CrossOrigin(origins = {"http://localhost:3000"},allowCredentials = "true",allowedHeaders = {"X-Custom-Header"},
        maxAge = 3600L, methods={RequestMethod.GET,RequestMethod.POST,RequestMethod.HEAD})
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/userLogin"}, method = RequestMethod.POST)
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

    @RequestMapping(value = {"/userRegister"}, method = RequestMethod.POST)
    public String register(@RequestParam(value = "account") String account,
                           @RequestParam(value = "username") String username,
                           @RequestParam(value = "password1") String password1,
                           @RequestParam(value = "password2") String password2) {
        if (!password1.equals(password2)) {
            return "two passwords isn't same";
        } else if(userService.queryUserByUsername(username)==null) {
                int res = userService.addUser(account,username, password1);
                return "register success";
        }
        return "account has existed";
    }

}
