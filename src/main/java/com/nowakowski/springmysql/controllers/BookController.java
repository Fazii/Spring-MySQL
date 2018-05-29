package com.nowakowski.springmysql.controllers;

import com.nowakowski.springmysql.book.Book;
import com.nowakowski.springmysql.book.BookService;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

  @Resource
  private BookService bookService;

  @RequestMapping(value = "api/v2/book/", method = RequestMethod.POST)
  public Book addNewUser(@RequestParam String title, @RequestParam String author) {
    return bookService.addBook(title, author);
  }

  @RequestMapping(value = "api/v2/book/{title}", method = RequestMethod.GET)
  public Book getBook(@PathVariable String title) {
    return bookService.findByTitle(title);
  }

  @RequestMapping(value = "api/v2/book/", method = RequestMethod.GET)
  public Iterable<Book> getAllBooks() {
    return bookService.findAll();
  }
}
