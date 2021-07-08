package org.example.shixun.serviceImpl;

import org.example.shixun.domain.User;
import org.example.shixun.dao.UserDao;
import org.example.shixun.exception.GlobalException;
import org.example.shixun.redis.RedisService;
import org.example.shixun.redis.UserKey;
import org.example.shixun.result.CodeMsg;
import org.example.shixun.service.UserService;
import org.example.shixun.util.MD5Util;
import org.example.shixun.util.UUIDUtil;
import org.example.shixun.vo.LoginVo;
import org.example.shixun.vo.RegisterVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    public static final String COOKI_NAME_TOKEN = "token";

    @Autowired
    UserDao userDao;

    @Autowired
    RedisService redisService;


    public User queryUserByUsername(String username) {
        return userDao.queryUserByUsername(username);
    }

    public User queryUserByMobile(String mobile) {
        return userDao.queryUserByMobile(mobile);
    }

    public List<User> queryUserList(){
        return userDao.queryUserList();
    };

    public int updateUser(User user){
        return userDao.updateUser(user);
    };


    @Override
    public String login(HttpServletResponse response, LoginVo loginVo){
        if(loginVo == null) {
            throw new GlobalException(CodeMsg.SERVER_ERROR);
        }
        String mobile = loginVo.getMobile();
        String formPass = loginVo.getPassword();
        //判断手机号是否存在
        User user = userDao.queryUserByMobile(mobile);
        if(user == null) {
            throw new GlobalException(CodeMsg.MOBILE_NOT_EXIST);
        }
        //验证密码
        String dbPass = user.getPassword();
        String salt = MD5Util.salt;
        String calcPass = MD5Util.formPassToDBPass(formPass, salt);
        if(!calcPass.equals(dbPass)) {
            throw new GlobalException(CodeMsg.PASSWORD_ERROR);
        }
        //生成cookie
        String token= UUIDUtil.uuid();
        addCookie(response, token, user);
        return token;
    }

    private void addCookie(HttpServletResponse response, String token, User user) {
        redisService.set(UserKey.token, token, user);
        Cookie cookie = new Cookie(COOKI_NAME_TOKEN, token);
        cookie.setMaxAge(UserKey.token.expireSeconds());
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    @Override
    public void register(HttpServletResponse response, RegisterVo registerVo) {
        User user = userDao.queryUserByMobile(registerVo.getMobile());
        if(user != null){
            throw  new GlobalException(CodeMsg.MOBILE_DUPLICATED);
        }
        userDao.addUser(registerVo.getMobile(),registerVo.getUsername(),
                registerVo.getPassword(),registerVo.getLabel());
    }
}
