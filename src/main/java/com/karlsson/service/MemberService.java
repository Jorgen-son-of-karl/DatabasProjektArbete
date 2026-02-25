package com.karlsson.service;

import com.karlsson.entity.Member;
import com.karlsson.repo.MemberRepository;

public class MemberService {

    private final MemberRepository memberRepository;
    public MemberService(MemberRepository memberRepository) { this.memberRepository = memberRepository; }

    public Member createMember(String name, String email) {
        if(name == null || name.isBlank()) throw new IllegalArgumentException("Namn krävs.");
        if (email == null || email.isBlank()) throw new IllegalArgumentException("Email krävs.");

        Member member = new Member(name.trim(), email.trim());
        memberRepository.save(member);
        return member;
    }
}
