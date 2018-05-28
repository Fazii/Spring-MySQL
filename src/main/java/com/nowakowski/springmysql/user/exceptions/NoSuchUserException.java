package com.nowakowski.springmysql.user.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "User with given name doesn't exist")
public class NoSuchUserException extends IllegalStateException {

  public NoSuchUserException() {
    super();
  }
}
