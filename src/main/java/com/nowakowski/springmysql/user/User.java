package com.nowakowski.springmysql.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.nowakowski.springmysql.book.Book;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "User")
@Table(name = "user")
@Getter
@Setter
public class User {

  @Id
  @JsonIgnore
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private String name;

  @Column(unique = true)
  private String email;

  @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
  @JsonManagedReference
  private Set<Book> books = new HashSet<>();
}
