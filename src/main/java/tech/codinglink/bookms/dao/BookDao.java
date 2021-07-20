package tech.codinglink.bookms.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tech.codinglink.bookms.entity.Book;

import java.util.List;

/**
 * Book的数据库操作类
 */
@Repository("bookDao")
public interface BookDao {
    /**
     * 通过书名查询图书
     *
     * @param name
     * @return
     */
    @Select("select * from book where book_name = #{name}")
    List<Book> queryBookByName(String name);

    @Select("select * from book")
    List<Book> queryBook();


    @Insert("insert into book(book_id,book_name,book_author,book_publish,book_category,book_price,book_introduction) values(#{bookId},#{bookName},#{bookAuthor},#{bookPublish},#{bookCategory},#{bookPrice},#{bookIntroduction})")
    int addBook(Integer bookId, String bookName, String bookAuthor, String bookPublish, String bookCategory, Float bookPrice, String bookIntroduction);
}
