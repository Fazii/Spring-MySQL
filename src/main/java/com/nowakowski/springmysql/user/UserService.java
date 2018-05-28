package com.nowakowski.springmysql.user;

import com.nowakowski.springmysql.user.exceptions.NoSuchUserException;
import com.nowakowski.springmysql.user.exceptions.UserWithGivenEmailAlreadyExistException;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;

@Component
public class UserService {

  @Resource
  private UserRepository userRepository;

  public User addUser(String name, String email) {
    if (userRepository.existsUserByEmail(email)) {
      throw new UserWithGivenEmailAlreadyExistException();
    }
    User user = new User();
    user.setName(name);
    user.setEmail(email);
    return userRepository.save(user);
  }

  public Iterable<User> findAll() {
    return userRepository.findAll();
  }

  public User findByName(String name) {
    User user = userRepository.findByName(name);
    if (user == null) {
      throw new NoSuchUserException();
    }
    return user;
  }
}
