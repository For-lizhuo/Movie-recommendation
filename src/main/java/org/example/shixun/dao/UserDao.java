package org.example.shixun.dao;

import org.apache.ibatis.annotations.Param;
import org.example.shixun.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserDao {
    List<User> queryUserList();

    User queryUserByUsername(String username);

    User queryUserByMobile(String mobile);

    int addUser(@Param("mobile") String mobile,@Param("username") String username,@Param("password") String password,@Param("label") String label);

    int updateUser(User user);

    int deleteUser(String username);
}
