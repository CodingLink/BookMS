package tech.codinglink.bookms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * BookCategory实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookCategory {
    private Integer categoryId;
    private String categoryName;
}
