package tech.codinglink.bookms.service;

import tech.codinglink.bookms.entity.Admin;

public interface AdminService {
    Admin adminLogin(String adminName, String password);
}
