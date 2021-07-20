package tech.codinglink.bookms.service.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import tech.codinglink.bookms.dao.AdminDao;
import tech.codinglink.bookms.entity.Admin;
import tech.codinglink.bookms.service.AdminService;

import javax.annotation.Resource;

@Service("adminService")
public class AdminServiceImpl implements AdminService {
    @Resource
    @Qualifier("adminDao")
    AdminDao adminDao;

    @Override
    public Admin adminLogin(String adminName, String password) {
        Admin admin = adminDao.adminLogin(adminName, password);
        if (admin == null)
            return null;
        else
            return admin;
    }
}
