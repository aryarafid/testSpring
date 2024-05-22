package com.belajar.testSpring.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

//@Entity(name="member")
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="member", schema="library_db2")
public class Member {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    @Column
    private String name;
    @Column
    private String phone;
    @OneToMany(mappedBy = "member")
    private List<Log> logs;
}
