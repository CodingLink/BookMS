package tech.codinglink.bookms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 管理员账户实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin {
    private Integer adminId;
    private String adminName;
    private String adminPwd;
    private String adminEmail;
}
