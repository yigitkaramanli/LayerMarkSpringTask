package com.lyrmrk.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lyrmrk.entity.Author;
import com.lyrmrk.entity.Book;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class AuthorResponse {
    @JsonProperty("Id")
    private Long id;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    private Set<Book> books;

    public AuthorResponse(Author author){
        this.id = author.getId();
        this.firstName= author.getFirstName();
        this.lastName= author.getLastName();
        this.books = author.getBooks();
    }
}
