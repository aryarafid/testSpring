package com.belajar.testSpring.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
//@NoArgsConstructor
public class BorrowRequest {
    private Integer memberId;
    private List<Integer> bookIds;
    private Date borrowingDate;
    private Date returnDate;
}
