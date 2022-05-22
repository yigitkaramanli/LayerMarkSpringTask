package com.lyrmrk.controller;

import com.lyrmrk.entity.Book;
import com.lyrmrk.request.CreateBookAndAuthorRequest;
import com.lyrmrk.request.CreateBookRequest;
import com.lyrmrk.response.BookResponse;
import com.lyrmrk.service.AuthorService;
import com.lyrmrk.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/book/")
public class BookController {

    @Autowired
    BookService bookService;

    @Autowired
    AuthorService authorService;

    @GetMapping("/getall")
    public List<BookResponse> getAllBooks(){
        List<Book> bookList = bookService.getAllBooks();
        List<BookResponse> bookResponseList = new ArrayList<BookResponse>();

        bookList.stream().forEach(book -> {
            bookResponseList.add(new BookResponse(book));
        });

        return bookResponseList;
    }

    @PostMapping("/create")
    public BookResponse createBook(@Valid @RequestBody CreateBookRequest createBookRequest){
        Book book = bookService.createBook(createBookRequest);
        return new BookResponse(book);
    }

    ////// MIGHT NOT WORK
    @PostMapping("/createBookWithAuthor")
    public BookResponse createBookAndAuthor(@Valid @RequestBody CreateBookAndAuthorRequest createBookAndAuthorRequest){
        Book book = bookService.createBookAndAuthor(createBookAndAuthorRequest);
        return new BookResponse(book);
    }

    @GetMapping("/{id}")
    public BookResponse getBook(@Valid @PathVariable Long id) {
        Book book = bookService.getBook(id);
        return new BookResponse(book);
    }

    @PutMapping("/{id}/author/{author_id}")
    public BookResponse addAuthorToBook(
            @Valid @PathVariable Long id, @Valid @PathVariable Long author_id) {
        Book book = bookService.addAuthorToBook(id,author_id);
        return new BookResponse(book);
    }

    @DeleteMapping("/{id}/author/{author_id}")
    public String removeAuthorFromBook(
            @Valid @PathVariable Long id,@Valid @PathVariable Long author_id){
        return bookService.removeAuthorFromBook(id,author_id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBook(@Valid @PathVariable Long id){
        return bookService.deleteBook(id);
    }

    @GetMapping("/findTitle/{title}")
    public List<BookResponse> findByTitle (@Valid @PathVariable String title){
        List<Book> bookList = bookService.findByTitle(title);
        List<BookResponse> bookResponseList = new ArrayList<>();

        bookList.stream().forEach(book -> {
            bookResponseList.add(new BookResponse(book));
        });

        return bookResponseList;
    }

    @GetMapping("/getByYear/{year}")
    public List<BookResponse> getByYear (@Valid @PathVariable Integer year){
        List<Book> bookList = bookService.getByYear(year);
        List<BookResponse> bookResponseList = new ArrayList<>();

        bookList.stream().forEach(book -> {
            bookResponseList.add(new BookResponse(book));
        });

        return bookResponseList;
    }

    @GetMapping("/yearBefore/{year}")
    public List<BookResponse> yearBefore( @Valid @PathVariable Integer year) {
        List<Book> bookList = bookService.yearBefore(year);
        List<BookResponse> bookResponseList = new ArrayList<>();

        bookList.stream().forEach(book -> {
            bookResponseList.add(new BookResponse(book));
        });

        return bookResponseList;
    }

    @GetMapping("/yearAfter/{year}")
    public List<BookResponse> yearAfter (@Valid @PathVariable Integer year){
        List<Book> bookList = bookService.yearAfter(year);
        List<BookResponse> bookResponseList = new ArrayList<>();

        bookList.stream().forEach(book -> {
            bookResponseList.add(new BookResponse(book));
        });

        return bookResponseList;
    }
}
