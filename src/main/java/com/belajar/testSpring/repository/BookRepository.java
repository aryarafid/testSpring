package com.belajar.testSpring.repository;

import com.belajar.testSpring.entities.Book;
import com.belajar.testSpring.entities.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {
    @Query(value = "SELECT * FROM books b " +
            "WHERE (:id IS NULL OR b.id = :id) " +
            "AND (:title IS NULL OR b.title = :title) " +
            "AND (:author IS NULL OR b.author = :author) " +
            "AND (:genre IS NULL OR b.genre = :genre) ",
            countQuery = "SELECT count(*) FROM books b " +
                    "WHERE (:id IS NULL OR b.id = :id) " +
                    "AND (:title IS NULL OR b.title = :title) " +
                    "AND (:author IS NULL OR b.author = :author) " +
                    "AND (:genre IS NULL OR b.genre = :genre) ",
            nativeQuery = true
    )
    Page<Book> getBooks(Integer id, String title, String author, String genre, Pageable pageable);


}
