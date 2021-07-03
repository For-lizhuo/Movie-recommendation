package org.example.shixun.serviceImpl;

import org.example.shixun.entity.User;
import org.example.shixun.mapper.UserMapper;
import org.example.shixun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper usermapper;

    public int addUser(String account,String username, String password) {
        return usermapper.addUser(account,username,password);
    }

    public User queryUserByUsername(String username) {
        return usermapper.queryUserByUsername(username);
    }

    public User queryUserByAccount(String account) {
        return usermapper.queryUserByAccount(account);
    }

    public List<User> queryUserList(){
        return usermapper.queryUserList();
    };

    public int updateUser(User user){
        return usermapper.updateUser(user);
    };

}
