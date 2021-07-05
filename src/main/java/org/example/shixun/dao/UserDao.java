package org.example.shixun.dao;

import org.example.shixun.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserDao {
    List<User> queryUserList();

    User queryUserByUsername(String username);

    User queryUserByAccount(String account);

    int addUser(String account,String username,String password);

    int updateUser(User user);

    int deleteUser(String username);
}
