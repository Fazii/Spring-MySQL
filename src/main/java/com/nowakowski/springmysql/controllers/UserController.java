package com.nowakowski.springmysql.controllers;

import com.nowakowski.springmysql.user.User;
import com.nowakowski.springmysql.user.UserService;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  @Resource
  private UserService userService;

  @RequestMapping(value = "api/v2/user/", method = RequestMethod.POST)
  public User addNewUser(@RequestParam String name, @RequestParam String email) {
    return userService.addUser(name, email);
  }

  @RequestMapping(value = "api/v2/user/{name}/book/{title}", method = RequestMethod.PUT)
  public User addNewRent(@PathVariable String name, @PathVariable String title) {
    return userService.addNewRent(name, title);
  }

  @RequestMapping(value = "api/v2/user/{name}", method = RequestMethod.GET)
  public User getUser(@PathVariable String name) {
    return userService.findByName(name);
  }

}
