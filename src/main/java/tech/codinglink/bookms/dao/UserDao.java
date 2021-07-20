package tech.codinglink.bookms.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tech.codinglink.bookms.entity.User;

import java.util.List;


/**
 * user的数据库操作类
 */
@Repository("userDao")
public interface UserDao {
    /**
     * 登录查询
     *
     * @param userName
     * @param pwd
     * @return
     */
    @Select("select * from \"user\" where user_name=#{userName} and user_pwd=#{pwd}")
    User userLogin(String userName, String pwd);

    @Select("select * from \"user\" ")
    List<User> selectAll();

    @Select("select count(*) from \"user\" ")
    int selectUserCount();

    @Delete("delete from \"user\" where user_id=#{userId}")
    int deleteUserById(Integer id);

    @Insert("insert into \"user\"(user_id,user_name,user_pwd,user_email) values(#{userId},#{userName},#{userPwd},#{userEmail})")
    int addUser(Integer userId, String userName, String userPwd, String userEmail);
}
