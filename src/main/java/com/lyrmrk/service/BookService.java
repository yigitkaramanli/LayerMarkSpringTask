package com.lyrmrk.service;

import com.lyrmrk.entity.Author;
import com.lyrmrk.entity.Book;
import com.lyrmrk.repository.AuthorRepository;
import com.lyrmrk.repository.BookRepository;
import com.lyrmrk.request.CreateBookAndAuthorRequest;
import com.lyrmrk.request.CreateBookRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public Book getBook(Long id){
        return bookRepository.findById(id).get();
    }

    public Book addAuthorToBook(Long id, Long a_id){
        Book book = getBook(id);
        Author author = authorRepository.findById(a_id).get();
        book.addAuthor(author);
        return bookRepository.save(book);

    }

    public String removeAuthorFromBook(Long id, Long a_id){
        Book book = getBook(id);
        Author author = authorRepository.findById(a_id).get();

        book.removeAuthor(author);
        book = bookRepository.save(book);
        return author.getFirstName() + " " + author.getLastName() + " has ben removed from the authors of the book " + book.getTitle();
    }

    public Book createBook(CreateBookRequest createBookRequest){
        Book book = new Book(createBookRequest);

        book = bookRepository.save(book);
        return book;
    }
    public Book createBookAndAuthor(CreateBookAndAuthorRequest createBookAndAuthorRequest){
        Book book = new Book(createBookAndAuthorRequest);
        Author author = authorRepository.findById(createBookAndAuthorRequest.getAuthor_id()).get();
        book.addAuthor(author);
        return bookRepository.save(book);
    }

    public String deleteBook(Long id) {
        Book book = getBook(id);
        bookRepository.deleteById(id);
        return "Book: " + book.getTitle() + " has been removed from the system.";
    }

    public List<Book> findByTitle(String title){
        return bookRepository.findBookByTitleContains(title);
    }

    public List<Book> getByYear(Integer year){
        return bookRepository.findBookByYear(year);
    }

    public List<Book> yearBefore(Integer year){
        return  bookRepository.findBookByYearBefore(year);
    }

    public List<Book> yearAfter(Integer year){
        return bookRepository.findBookByYearAfter(year);
    }
}
