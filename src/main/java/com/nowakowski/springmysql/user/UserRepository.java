package com.nowakowski.springmysql.user;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

  User findByName(String name);

  boolean existsUserByEmail(String email);
}
