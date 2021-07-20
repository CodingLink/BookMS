package tech.codinglink.bookms.controller;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tech.codinglink.bookms.entity.Book;
import tech.codinglink.bookms.service.BookService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Random;

@Controller("bookController")
@Scope("prototype")
public class bookController {
    @Resource
    @Qualifier("bookService")
    private BookService bookService;

    @RequestMapping("/qiantai/queryBookByName")
    public String queryBookByName(@RequestParam("bookName") String name, HttpServletRequest request) {
        List<Book> bookList = bookService.queryBookByName(name);
        request.getSession().setAttribute("bookList", bookList);
        System.out.println(bookList);
        return "/qiantai/findBook";
    }

    @RequestMapping("/qiantai/queryBook")
    public String queryBook(HttpServletRequest request) {
        List<Book> bookList = bookService.queryBook();
        request.getSession().setAttribute("bookList", bookList);
        return "/qiantai/findBook";
    }

    @RequestMapping("/admin/queryBookByName")
    public String queryBookByName_admin(@RequestParam("bookName") String name, HttpServletRequest request) {
        List<Book> bookList = bookService.queryBookByName(name);
        request.getSession().setAttribute("bookList", bookList);
        System.out.println(bookList);
        return "/admin/findBook";
    }

    @RequestMapping("/admin/queryBook")
    public String queryBook_admin(HttpServletRequest request) {
        List<Book> bookList = bookService.queryBook();
        request.getSession().setAttribute("bookList", bookList);
        return "/admin/findBook";
    }

    @RequestMapping("/admin/addBook")
    public String addBook(@RequestParam("bookName") String bookName, @RequestParam("bookAuthor") String bookAuthor, @RequestParam("bookPublish") String bookPublish, @RequestParam("bookCategory") String bookCategory, @RequestParam("bookPrice") Float bookPrice, @RequestParam("bookIntroduction") String bookIntroduction) {
        bookService.addBook(new Random().nextInt(100), bookName, bookAuthor, bookPublish, bookCategory, bookPrice, bookIntroduction);
        return "/admin/addBook";
    }

    @RequestMapping("/admin/addBook1")
    public String addBook1() {
        return "/admin/addBook";
    }
}
