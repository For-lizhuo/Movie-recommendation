package com.example.movierecommendation.controller;

import com.example.movierecommendation.mapper.UserMapper;
import com.example.movierecommendation.pojo.User;
import com.example.movierecommendation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
//@RestController
@RequestMapping(value = {"/user"})
public class UserController {

    @Autowired
    private UserService userService;
    private UserMapper userMapper;

    @RequestMapping(value = {"/userLogin"}, method = RequestMethod.POST)
    public String login(@RequestParam(value = "username") String username,
                        @RequestParam(value = "password") String password) {
        if(userService.queryUserByUsername(username)==null) {
            return "redirect:userLogin.html";
        }
        else if(!userService.queryUserByUsername(username).getPassword().equals(password)) {
            return "redirect:userLogin.html";
        }
        else
            return "redirect:index.html";
    }

    @RequestMapping(value = {"/userRegister"}, method = RequestMethod.POST)
    public String register(@RequestParam(value = "username") String username,
                           @RequestParam(value = "password1") String password1,
                           @RequestParam(value = "password2") String password2) {
        if (!password1.equals(password2)) {
            return "redirect:userRegister.html";
        } else if(userService.queryUserByUsername(username)==null) {
                int res = userService.addUser(username, password1);
                return "redirect:userLogin.html";
        }
        return "redirect:userRegister.html";
    }

}
