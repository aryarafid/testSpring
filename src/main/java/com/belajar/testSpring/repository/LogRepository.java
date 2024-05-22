package com.belajar.testSpring.repository;

import com.belajar.testSpring.entities.Log;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface LogRepository extends CrudRepository<Log, Integer> {
    @Query(value = "SELECT * FROM log l " +
            "WHERE (:id IS NULL OR l.id = :id) " +
            "AND (:member IS NULL OR l.member = :member) " +
            "AND (:book_id IS NULL OR l.book_id = :book_id) " +
            "AND (:borrowing_date IS NULL OR l.borrowing_date = :borrowing_date) " +
            "AND (:return_date IS NULL OR l.return_date = :return_date) ",
            countQuery = "SELECT count(*) FROM log l " +
                    "WHERE (:id IS NULL OR l.id = :id)   " +
                    "AND (:member IS NULL OR l.member = :member) " +
                    "AND (:book_id IS NULL OR l.book_id = :book_id) " +
                    "AND (:borrowing_date IS NULL OR l.borrowing_date = :borrowing_date) " +
                    "AND (:return_date IS NULL OR l.return_date = :return_date) ",
            nativeQuery = true
    )
    Page<Log> getLog(Integer id, String member, String borrowing_date, String return_date, Pageable pageable);
}
