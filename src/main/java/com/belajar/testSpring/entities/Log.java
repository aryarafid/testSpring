package com.belajar.testSpring.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="log", schema="library_db2")
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="member_id")
    private Integer member_id;

    @ManyToOne
    @JoinColumn(name="book_id")
    private Book book;

    @Column
    private Date borrowing_date;

    @Column
    private Date return_date;
}
