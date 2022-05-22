package com.lyrmrk.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.lyrmrk.request.CreateBookAndAuthorRequest;
import com.lyrmrk.request.CreateBookRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Getter
@Setter
@Entity
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "Author"})
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long book_id;

    @Column(name = "Title")
    private String title;

    @Column(name = "Year")
    private Integer year;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "books_authors",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "id")
    )
    private Set<Author> authors = new HashSet<>();

    public Book(String title, Integer year){
        this.title = title;
        this.year = year;
    }

    public Book(CreateBookRequest createBookRequest){
        this.title = createBookRequest.getTitle();
        this.year = createBookRequest.getYear();
    }

    public Book (CreateBookAndAuthorRequest createBookAndAuthorRequest){
        this.title = createBookAndAuthorRequest.getTitle();
        this.year = createBookAndAuthorRequest.getYear();
    }

    public void addAuthor(Author author){
        this.authors.add(author);
    }

    public void removeAuthor(Author author) {
        this.authors.remove(author);
    }
}
