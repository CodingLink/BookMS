package tech.codinglink.bookms.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.codinglink.bookms.entity.Admin;
import tech.codinglink.bookms.service.AdminService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller("adminController")
@Scope("prototype")
public class AdminController {
    @Resource
    @Qualifier("adminService")
    AdminService adminService;

    @RequestMapping("adminLogin")
    public String userLogin(@Param("userName") String userName,
                            @Param("password") String password, HttpServletRequest request) {
        Admin admin = adminService.adminLogin(userName, password);

        if (null != admin) {
            // flag = 0 表示用户名密码校验成功  【用于前端校验】
            request.getSession().setAttribute("flag", 0);
            request.getSession().setAttribute("admin", admin);
            return "admin/index";
        }

        // flag 为 1 表示 登录失败 【用于前端校验】
        request.getSession().setAttribute("flag", 1);
        return "index";
    }


}
