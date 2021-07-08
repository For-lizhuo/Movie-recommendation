package org.example.shixun.service;

import org.example.shixun.domain.User;
import org.example.shixun.vo.LoginVo;
import org.example.shixun.vo.RegisterVo;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface UserService {


    User queryUserByMobile(String mobile);

    User queryUserByUsername(String username);

    int updateUser(User user);

    List<User> queryUserList();

    String login(HttpServletResponse response, LoginVo loginVo);

    void register(HttpServletResponse response, RegisterVo registerVo);

    User getByToken(HttpServletResponse response, String token);

    int addUserInfo(User user);

}
