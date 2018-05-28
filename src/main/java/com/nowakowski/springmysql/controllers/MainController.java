package com.nowakowski.springmysql.controllers;

import com.nowakowski.springmysql.user.User;
import com.nowakowski.springmysql.user.UserService;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

  @Resource
  private UserService userService;

  @RequestMapping(value = "/add", method = RequestMethod.POST)
  public User addNewUser(@RequestParam String name, @RequestParam String email) {
    return userService.addUser(name, email);
  }

  @RequestMapping(value = "/get", method = RequestMethod.GET)
  public User getUser(@RequestParam String name) {
    return userService.findByName(name);
  }

  @RequestMapping(value = "/getAll", method = RequestMethod.GET)
  public Iterable<User> getAllUsers() {
    return userService.findAll();
  }
}
