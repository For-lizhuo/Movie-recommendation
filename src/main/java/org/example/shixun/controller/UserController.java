package org.example.shixun.controller;

import org.example.shixun.domain.User;
import org.example.shixun.redis.RedisService;
import org.example.shixun.result.CodeMsg;
import org.example.shixun.result.Result;
import org.example.shixun.service.UserService;
import org.example.shixun.vo.LoginVo;
import org.example.shixun.vo.RegisterVo;
import org.example.shixun.vo.UserPageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

//@Controller
@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000",maxAge = 3600)
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
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public Result<String> doLogin(HttpServletResponse response, @RequestBody @Valid LoginVo loginVo) {
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

    @RequestMapping("/userPage")
    @ResponseBody
    public Result<UserPageVo> getUserPage(User user){
        if(user == null){
            return Result.error(CodeMsg.SESSION_ERROR);
        }
        UserPageVo userPageVo = new UserPageVo();

        userPageVo.setLabel(user.getLabel());
        userPageVo.setPicture(user.getPicture());
        userPageVo.setProfile(user.getProfile());
        userPageVo.setUsername(user.getUsername());

        return Result.success(userPageVo);
    }

    @RequestMapping(value = "/setUserPage",method = RequestMethod.POST)
    @ResponseBody
    public Result<String> setUserPage(User user, UserPageVo userPageVo){
        if(user == null){
            return Result.error(CodeMsg.SESSION_ERROR);
        }
        user.setLabel(userPageVo.getLabel());
        user.setUsername(userPageVo.getUsername());
        user.setPicture(userPageVo.getPicture());
        user.setProfile(userPageVo.getProfile());

        userService.addUserInfo(user);

        return Result.success("完善信息成功");
    }


}
