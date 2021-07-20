package tech.codinglink.bookms.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * BorrowBook实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BorrowBook {
    private Integer id;
    private Integer userId;
    private Integer bookId;
    private Date date;
}
