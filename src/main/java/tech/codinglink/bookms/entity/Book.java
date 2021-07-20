package tech.codinglink.bookms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * book实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private Integer bookId;
    private String bookName;
    private String bookAuthor;
    private String bookPublish;
    private String bookCategory;
    private Float bookPrice;
    private String bookIntroduction;
}
