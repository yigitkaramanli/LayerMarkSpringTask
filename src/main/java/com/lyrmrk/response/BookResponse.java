package com.lyrmrk.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.lyrmrk.entity.Author;
import com.lyrmrk.entity.Book;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
public class BookResponse {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("Title")
    private String title;

    @JsonProperty("Year")
    private Integer year;

    private Set<Author> authors;

    public BookResponse (Book book){
        this.id = book.getBook_id();
        this.title = book.getTitle();
        this.year = book.getYear();
        this.authors = book.getAuthors();
    }
}
