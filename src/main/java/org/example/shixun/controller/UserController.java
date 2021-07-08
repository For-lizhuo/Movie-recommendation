package org.example.shixun.controller;

import org.example.shixun.domain.User;
import org.example.shixun.redis.RedisService;
import org.example.shixun.result.Result;
import org.example.shixun.service.UserService;
import org.example.shixun.vo.LoginVo;
import org.example.shixun.vo.RegisterVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

//@Controller
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    RedisService redisService;

    @GetMapping(value = {"userList"})
    public List<User> getUser() {
        return userService.queryUserList();
    }

    @RequestMapping(value = {"/getUser"}, method = RequestMethod.POST)
    public User getUser(@RequestParam(value = "username") String username) {
        return userService.queryUserByUsername(username);
    }

    //登录接口，返回token
    @PostMapping("/login")
    @ResponseBody
    public Result<String> doLogin(HttpServletResponse response, @Valid LoginVo loginVo) {
        //登录
        String token = userService.login(response, loginVo);
        return Result.success(token);
    }

    //注册接口
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public Result<String> doRegister(HttpServletResponse response,  @RequestBody @Valid RegisterVo registerVo) {
        //注册
        userService.register(response, registerVo);

        return Result.success("register success");
    }

    @RequestMapping("/updateUser")
    public String updateUser(@RequestBody User user) {
        userService.updateUser(user);
        return "success";
    }
}
