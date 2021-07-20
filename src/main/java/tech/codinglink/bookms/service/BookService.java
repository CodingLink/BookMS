package tech.codinglink.bookms.service;

import org.springframework.stereotype.Service;
import tech.codinglink.bookms.entity.Book;

import java.util.List;

@Service("bookService")
public interface BookService {
    List<Book> queryBookByName(String name);

    List<Book> queryBook();

    int addBook(Integer bookId, String bookName, String bookAuthor, String bookPublish, String bookCategory, Float bookPrice, String bookIntroduction);
}
