package com.belajar.testSpring.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="book", schema="library_db2")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private String title;
    @Column
    private String author;
    @Column
    private String genre;
    @OneToMany(mappedBy = "book")
    private List<Log> logs;

}
