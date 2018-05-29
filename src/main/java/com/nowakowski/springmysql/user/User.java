package com.nowakowski.springmysql.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nowakowski.springmysql.book.Book;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

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

  @OneToMany(
      mappedBy = "owner",
      cascade = CascadeType.ALL,
      orphanRemoval = true
  )
  private Set<Book> books = new HashSet<>();


}
