package com.lyrmrk.controller;


import com.lyrmrk.entity.Author;
import com.lyrmrk.request.CreateAuthorRequest;
import com.lyrmrk.request.CreateBookAndAuthorRequest;
import com.lyrmrk.response.AuthorResponse;
import com.lyrmrk.service.AuthorService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/author/")
public class AuthorController {
    @Autowired
    AuthorService authorService;

    @GetMapping("/getall")
    public List<AuthorResponse> getAllAuthors(){
        List<Author> authorList = authorService.getAllAuthors();
        List<AuthorResponse> authorResponseList = new ArrayList<AuthorResponse>();

        authorList.stream().forEach(author -> {
            authorResponseList.add(new AuthorResponse(author));
        });

        return authorResponseList;
    }
    @PostMapping("/create")
    public AuthorResponse createAuthor(@Valid @RequestBody CreateAuthorRequest createAuthorRequest){
        Author author = authorService.createAuthor(createAuthorRequest);

        return new AuthorResponse(author);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteAuthor(@Valid @PathVariable Long id){
        return authorService.deleteAuthor(id);
    }

    @GetMapping("/{id}")
    public AuthorResponse getOne (@Valid @PathVariable Long id){
        Author author = authorService.getAuthor(id);
        return new AuthorResponse(author);
    }

    @PutMapping("/{id}/book/{book_id}")
    public AuthorResponse addBookToAuthor(@Valid @PathVariable Long id, @Valid @PathVariable Long book_id) {
        Author author= authorService.addBookToAuthor(id,book_id);
        return new AuthorResponse(author);
    }

    @DeleteMapping("/{id}/book/{book_id}")
    public String removeBookFromAuthor(@Valid @PathVariable Long id, @Valid @PathVariable Long book_id){
        return authorService.removeBookFromAuthor(id,book_id);
    }

    @PostMapping("/createAuthorWithBook")
    public AuthorResponse CreateAuthorAndBook(@Valid @RequestBody CreateBookAndAuthorRequest createBookAndAuthorRequest){
        Author author = authorService.createAuthorAndBook(createBookAndAuthorRequest);
        return new AuthorResponse(author);
    }

    @GetMapping("firstName/{firstName}")
    public List<AuthorResponse> findByName(@Valid @PathVariable String firstName){
        List<Author> authorList = authorService.findByFirstName(firstName);
        List<AuthorResponse> authorResponseList = new ArrayList<AuthorResponse>();

        authorList.stream().forEach(author -> {
            authorResponseList.add(new AuthorResponse(author));
        });

        return authorResponseList;
    }

    @GetMapping("lastName/{lastName}")
    public List<AuthorResponse> findByLastName(@Valid @PathVariable String lastName){
        List<Author> authorList = authorService.findByLastName(lastName);
        List<AuthorResponse> authorResponseList = new ArrayList<AuthorResponse>();

        authorList.stream().forEach(author -> {
            authorResponseList.add(new AuthorResponse(author));
        });

        return authorResponseList;
    }

    @GetMapping("/getPrecise/{firstName}/{lastName}")
    public List<AuthorResponse> getPreciseName( @Valid @PathVariable String firstName, @Valid @PathVariable String lastName){
        List<Author> authorList = authorService.findByPreciseName(firstName,lastName);
        List<AuthorResponse> authorResponseList = new ArrayList<AuthorResponse>();

        authorList.stream().forEach(author -> {
            authorResponseList.add(new AuthorResponse(author));
        });

        return authorResponseList;
    }

}
