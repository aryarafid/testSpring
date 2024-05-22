package com.belajar.testSpring.services.interfaces;

import com.belajar.testSpring.entities.Member;
import org.springframework.data.domain.Page;

public interface MemberService {
    //    c
    Member saveMember(Member member);

    //    r
    Page<Member> getAllMembers(Integer id, String name, String phone);

    //    u
    Member updateMember(Member Member, Integer id);

    //    d
    void deleteMember(Integer id);
}
