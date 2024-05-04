package com.mju.capstone.member.repository;

import com.mju.capstone.member.entity.Member;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long> {

  Optional<Member> findByEmail(String email);

  boolean existsByEmail(String email);

}