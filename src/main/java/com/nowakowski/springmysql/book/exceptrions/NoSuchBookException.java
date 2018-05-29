package com.nowakowski.springmysql.book.exceptrions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Book with given title doesn't exist")
public class NoSuchBookException extends IllegalStateException {

  public NoSuchBookException() {
    super();
  }
}
