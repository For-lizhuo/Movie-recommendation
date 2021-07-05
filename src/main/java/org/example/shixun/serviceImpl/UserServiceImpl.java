package org.example.shixun.serviceImpl;

import org.example.shixun.entity.User;
import org.example.shixun.dao.UserDao;
import org.example.shixun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public int addUser(String account,String username, String password) {
        return userDao.addUser(account,username,password);
    }

    public User queryUserByUsername(String username) {
        return userDao.queryUserByUsername(username);
    }

    public User queryUserByAccount(String account) {
        return userDao.queryUserByAccount(account);
    }

    public List<User> queryUserList(){
        return userDao.queryUserList();
    };

    public int updateUser(User user){
        return userDao.updateUser(user);
    };

}
