package com.belajar.testSpring.controller;

import com.belajar.testSpring.request.BorrowRequest;
import com.belajar.testSpring.services.interfaces.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Date;

@RestController
@RequestMapping("/api/log")
public class LogController {
    @Autowired
    private LogService logService;

    @PostMapping("/borrow")
    public ResponseEntity<String> borrowBooks(@RequestBody BorrowRequest request){
        Integer memberId = request.getMemberId();
        List<Integer> bookIds = request.getBookIds();
        Date borrowingDate = request.getBorrowingDate();
        Date returnDate = request.getReturnDate();
        ResponseEntity<String> response = logService.borrowBooks(memberId, bookIds, borrowingDate, returnDate);
        return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
    }
}
