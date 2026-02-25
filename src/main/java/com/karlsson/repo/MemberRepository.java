package com.karlsson.repo;

import com.karlsson.entity.Member;

import java.util.List;

public interface MemberRepository {

    void save(Member member);
    void update(Member member);
    void delete(Member member);
    Member findById(int id);
    List<Member> findAll();
}
