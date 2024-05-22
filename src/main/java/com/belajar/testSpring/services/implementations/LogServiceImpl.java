package com.belajar.testSpring.services.implementations;

import com.belajar.testSpring.entities.Log;
import com.belajar.testSpring.repository.LogRepository;
import com.belajar.testSpring.services.interfaces.LogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class LogServiceImpl implements LogService {

    private LogRepository logRepository;

    @Override
    public ResponseEntity<String> borrowBooks(Integer memberId, List<Integer> bookIds, Date borrowingDate, Date returnDate) {
        try {
            for (Integer bookId: bookIds){
                Log logEntry = new Log();
                logEntry.setMember_id(memberId);
                logEntry.setBorrowing_date(borrowingDate);
                logEntry.setReturn_date(returnDate);
                logRepository.save(logEntry);
            }
            return ResponseEntity.ok("Success");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to borrow books: " + e.getMessage());
        }
    }
}
