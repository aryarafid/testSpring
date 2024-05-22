package com.belajar.testSpring.repository;

import com.belajar.testSpring.entities.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends CrudRepository<Member, Integer> {
    @Query(value = "SELECT * FROM members m " +
            "WHERE (:id IS NULL OR m.id = :id) " +
            "and (:name IS NULL OR m.name = :name) " +
            "and (:phone IS NULL OR m.phone = :phone) ",
            countQuery = "SELECT count(*) FROM members m " +
                    "WHERE (:id IS NULL OR m.id = :id) " +
                    "and (:name IS NULL OR m.name = :name) " +
                    "and (:phone IS NULL OR m.phone = :phone) ",
            nativeQuery = true
    )
    Page<Member> getMembers(Integer id, String name, String phone, Pageable pageable);

}
