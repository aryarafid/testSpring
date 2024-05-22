package com.belajar.testSpring.services.interfaces;

import com.belajar.testSpring.entities.Book;
import com.belajar.testSpring.entities.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {
    //    c
    Book saveBook(Book book);

    //    r
    Page<Book> getAllBooks(Integer id, String title, String author, String genre);

    //    u
    Book updateBook(Book book, Integer id);

    //    d
    void deleteBook(Integer id);

}
