package com.nowakowski.springmysql.user;

import com.nowakowski.springmysql.book.Book;
import com.nowakowski.springmysql.book.BookRepository;
import com.nowakowski.springmysql.user.exceptions.NoSuchUserException;
import com.nowakowski.springmysql.user.exceptions.UserWithGivenEmailAlreadyExistException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Set;

@Component
public class UserService {

  @Resource private UserRepository userRepository;

  @Resource private BookRepository bookRepository;

  public User addUser(String name, String email) {
    if (userRepository.existsUserByEmail(email)) {
      throw new UserWithGivenEmailAlreadyExistException();
    }
    User user = new User();
    user.setName(name);
    user.setEmail(email);
    return userRepository.save(user);
  }

  public User findByName(String name) {
    User user = userRepository.findByName(name);
    if (user == null) {
      throw new NoSuchUserException();
    }
    return user;
  }

  public User addNewRent(String name, String title) {
    User user = userRepository.findByName(name);
    Book book = bookRepository.findByTitle(title);

    Set<Book> books = user.getBooks();
    books.add(book);
    user.setBooks(books);

    book.setOwner(user);
    bookRepository.save(book);
    return userRepository.save(user);
  }
}
