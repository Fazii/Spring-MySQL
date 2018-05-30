package com.nowakowski.springmysql.book;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nowakowski.springmysql.user.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "Book")
@Table(name = "book")
@Getter
@Setter
public class Book {

  @Id
  @JsonIgnore
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private String title;

  private String author;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  @JsonBackReference
  private User owner;

  @Override
  public boolean equals(Object o) {
      return this == o || o instanceof Book && id != null && id.equals(((Book) o).id);
  }

  @Override
  public int hashCode() {
    return 31;
  }
}
