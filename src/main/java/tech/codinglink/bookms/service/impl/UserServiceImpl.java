package tech.codinglink.bookms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import tech.codinglink.bookms.dao.UserDao;
import tech.codinglink.bookms.entity.User;
import tech.codinglink.bookms.service.UserService;

import java.util.List;


/**
 * User服务实现类
 */
@Service("userService")
@Scope("prototype")
public class UserServiceImpl implements UserService {

    @Autowired
    @Qualifier("userDao")
    private UserDao userDao;

    /**
     * 登录查询
     *
     * @param userName
     * @param pwd
     * @return
     */

    @Override
    public User userLogin(String userName, String pwd) {
        User user = userDao.userLogin(userName, pwd);
        if (user == null)
            return null;
        else
            return user;
    }

    @Override
    public List<User> selectAll() {
        List<User> users = userDao.selectAll();
        return users;
    }

    @Override
    public int deleteUserById(Integer id) {
        return userDao.deleteUserById(id);
    }

    @Override
    public int addUser(Integer userId, String userName, String userPwd, String userEmail) {
        return userDao.addUser(userId, userName, userPwd, userEmail);
    }

}
