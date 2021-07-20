package tech.codinglink.bookms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import tech.codinglink.bookms.dao.BookDao;
import tech.codinglink.bookms.entity.Book;
import tech.codinglink.bookms.service.BookService;

import javax.annotation.Resource;
import java.util.List;

@Service("bookService")
@Scope("prototype")
public class BookServiceImpl implements BookService {
    @Resource
    @Qualifier("bookDao")
    private BookDao bookDao;

    @Override
    public List<Book> queryBookByName(String name) {
        return bookDao.queryBookByName(name);
    }

    @Override
    public List<Book> queryBook() {
        return bookDao.queryBook();
    }

    @Override
    public int addBook(Integer bookId, String bookName, String bookAuthor, String bookPublish, String bookCategory, Float bookPrice, String bookIntroduction) {
        return bookDao.addBook(bookId, bookName, bookAuthor, bookPublish, bookCategory, bookPrice, bookIntroduction);
    }
}
