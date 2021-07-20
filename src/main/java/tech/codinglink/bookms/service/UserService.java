package tech.codinglink.bookms.service;

import tech.codinglink.bookms.entity.User;

import java.util.List;

public interface UserService {
    //用户登录
    User userLogin(String userName, String password);

    //查询用户
    List<User> selectAll();

    int deleteUserById(Integer id);

    int addUser(Integer userId, String userName, String userPwd, String userEmail);
}
