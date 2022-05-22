package com.lyrmrk.service;


import com.lyrmrk.entity.Author;
import com.lyrmrk.entity.Book;
import com.lyrmrk.repository.AuthorRepository;
import com.lyrmrk.repository.BookRepository;
import com.lyrmrk.request.CreateAuthorRequest;
import com.lyrmrk.request.CreateBookAndAuthorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    BookRepository bookRepository;

    public List<Author> getAllAuthors(){
        return authorRepository.findAll();
    }

    public Author getAuthor(Long id) {
        return authorRepository.findById(id).get();
    }

    public Author createAuthor(CreateAuthorRequest createAuthorRequest){
        Author author = new Author(createAuthorRequest);

        return authorRepository.save(author);
    }

    public String deleteAuthor(Long id) {
        Author author = getAuthor(id);
        authorRepository.deleteById(id);
        return author.getFirstName()+ " " + author.getLastName()+ " has been successfully deleted";
    }

    public Author addBookToAuthor(Long id, Long book_id) {
        Author author = authorRepository.findById(id).get();
        Book book = bookRepository.findById(book_id).get();

        author.addBook(book);
        author = authorRepository.save(author);
        return author;
    }

    public String removeBookFromAuthor( Long id , Long book_id) {
        Author author = getAuthor(id);
        Book book = bookRepository.findById(book_id).get();

        author.removeBook(book);
        author = authorRepository.save(author);

        return book.getTitle() + " has been removed from the books of the author " + author.getFirstName() + " " + author.getLastName();
    }

    public Author createAuthorAndBook(CreateBookAndAuthorRequest createBookAndAuthorRequest) {
        Author author = new Author(createBookAndAuthorRequest);
        Book book = bookRepository.findById(createBookAndAuthorRequest.getBook_id()).get();

        author.addBook(book);
        author = authorRepository.save(author);
        return author;
    }

    public List<Author> findByFirstName(String firstName) {
         return authorRepository.findAuthorByFirstNameStartingWith(firstName);
    }

    public List<Author> findByLastName(String lastName){
        return authorRepository.findAuthorByLastNameStartingWith(lastName);
    }

    public List <Author> findByPreciseName(String firstName, String lastName){
        return authorRepository.findAuthorByFirstNameStartingWithAndAndLastNameStartingWith(firstName,lastName);
    }
}
