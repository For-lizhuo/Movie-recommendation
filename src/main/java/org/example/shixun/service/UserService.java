package org.example.shixun.service;

import org.example.shixun.domain.User;
import org.example.shixun.vo.LoginVo;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface UserService {

    //注册新用户
    int addUser(String account, String username, String password);

    User queryUserByAccount(String account);

    User queryUserByUsername(String username);

    int updateUser(User user);

    List<User> queryUserList();

    //todo:
    String login(HttpServletResponse response, LoginVo loginVo);

}
