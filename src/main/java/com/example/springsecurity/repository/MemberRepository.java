package com.example.springsecurity.repository;

import com.example.springsecurity.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByMemberId(String MemberId);
    Optional<Member> findByNickname(String nickname);
}
