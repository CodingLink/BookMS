package tech.codinglink.bookms.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tech.codinglink.bookms.entity.Admin;

@Repository("adminDao")
public interface AdminDao {
    /**
     * 登录查询
     *
     * @param adminName
     * @param pwd
     * @return
     */
    @Select("select * from \"admin\" where admin_name=#{adminName} and admin_pwd=#{pwd}")
    Admin adminLogin(String adminName, String pwd);
}
