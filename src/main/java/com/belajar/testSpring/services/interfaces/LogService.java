package com.belajar.testSpring.services.interfaces;

import com.belajar.testSpring.entities.Book;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.List;

public interface LogService {
//    crud?
    ResponseEntity<String> borrowBooks(Integer memberId, List<Integer> bookIds, Date borrowingDate, Date returnDate);
}
