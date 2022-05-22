package com.lyrmrk.repository;

import com.lyrmrk.entity.Author;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {
    List<Author> findAuthorByFirstNameStartingWith(String firstName);
    List<Author> findAuthorByLastNameStartingWith(String lastName);

    List<Author> findAuthorByFirstNameStartingWithAndAndLastNameStartingWith(String firstName, String lastName);
}
