package com.lyrmrk.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.lyrmrk.request.CreateAuthorRequest;
import com.lyrmrk.request.CreateBookAndAuthorRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "Book"})
@Table(name="author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="author_id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @JsonIgnore
    @ManyToMany(mappedBy = "authors",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Book> books = new HashSet<>();

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public Author(CreateAuthorRequest createAuthorRequest){
        this.firstName = createAuthorRequest.getFirstName();
        this.lastName = createAuthorRequest.getLastName();
    }

    public Author(CreateBookAndAuthorRequest createBookAndAuthorRequest) {
        this.firstName = createBookAndAuthorRequest.getFirstName();
        this.lastName = createBookAndAuthorRequest.getLastName();
    }

    public void addBook(Book book){
        this.books.add(book);
    }

    public void removeBook(Book book){ this.books.remove(book);}


}
