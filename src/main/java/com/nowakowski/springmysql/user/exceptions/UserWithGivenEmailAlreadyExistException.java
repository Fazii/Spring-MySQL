package com.nowakowski.springmysql.user.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "User with given e-mail already exist")
public class UserWithGivenEmailAlreadyExistException extends IllegalStateException {

  public UserWithGivenEmailAlreadyExistException() {
    super();
  }
}
