package com.nowakowski.springmysql.book;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nowakowski.springmysql.user.User;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

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
  @JsonIgnore
  private User owner;

  private String ownerName;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Book)) {
      return false;
    }
    return id != null && id.equals(((Book) o).id);
  }

  @Override
  public int hashCode() {
    return 31;
  }
}
