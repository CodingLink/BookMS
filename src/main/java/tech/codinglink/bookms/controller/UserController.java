package tech.codinglink.bookms.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import tech.codinglink.bookms.entity.User;
import tech.codinglink.bookms.service.UserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Random;


@Controller("userController")
@Scope("prototype")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    @Qualifier("userService")
    private UserService userService;

    /**
     * 用户登录
     *
     * @param userName
     * @return
     */
    @RequestMapping("userLogin")
    public String userLogin(@Param("userName") String userName,
                            @Param("password") String password, HttpServletRequest request) {
        User user = userService.userLogin(userName, password);

        if (null != user) {
            // flag = 0 表示用户名密码校验成功  【用于前端校验】
            request.getSession().setAttribute("flag", 0);

            request.getSession().setAttribute("user", user);
            return "qiantai/index";
        }

        // flag 为 1 表示 登录失败 【用于前端校验】
        request.getSession().setAttribute("flag", 1);
        return "index";
    }

    /**
     * 返回查询用户页面
     */
    @RequestMapping("/admin/selectAll")
    public String selectAll(HttpServletRequest request) {
        List<User> users = userService.selectAll();
        request.getSession().setAttribute("users", users);
        System.out.println(users);
        return "admin/findUser";
    }

    @RequestMapping("/deleteUser")
    @ResponseBody
    public String deleteUserById(@RequestParam("userId") Integer userId) {
        int res = userService.deleteUserById(userId);
        if (res > 0) {
            return "true";
        }
        return "false";
    }


    @RequestMapping("/addUser")
    @ResponseBody
    public String addUser(@RequestParam("userName") String userName, @RequestParam("userPwd") String userPwd, @RequestParam("userEmail") String userEmail) {
        int res = userService.addUser(new Random().nextInt(100), userName, userPwd, userEmail);
        if (res > 0) {
            return "true";
        } else {
            return "false";
        }
    }


    /**
     * 返回新增用户页面
     */
    @RequestMapping("/addUserPage")
    public String addUserPage() {
        return "admin/addUser";
    }
}
