package com.nowakowski.springmysql.book;

import com.nowakowski.springmysql.book.exceptrions.NoSuchBookException;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;

@Component
public class BookService {

  @Resource
  private BookRepository bookRepository;

  public Book addBook(String title, String author) {
    Book book = new Book();
    book.setTitle(title);
    book.setAuthor(author);
    return bookRepository.save(book);
  }

  public Book findByTitle(String title) {
    Book book = bookRepository.findByTitle(title);
    if (book == null) {
      throw new NoSuchBookException();
    }
    return book;
  }

  public Iterable<Book> findAll() {
    return bookRepository.findAll();
  }

  public Book save(Book book) {
    return bookRepository.save(book);
  }
}
