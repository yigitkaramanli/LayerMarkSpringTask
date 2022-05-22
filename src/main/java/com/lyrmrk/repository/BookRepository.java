package com.lyrmrk.repository;

import com.lyrmrk.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
    List<Book> findBookByTitleContains (String title);

    List<Book> findBookByYear(Integer year);

    List<Book> findBookByYearBefore(Integer year);

    List<Book> findBookByYearAfter(Integer year);
}
