package com.karlsson.service;

import com.karlsson.entity.Member;
import com.karlsson.repo.MemberRepository;

import java.util.List;

public class MemberService {

    private final MemberRepository memberRepository;
    public MemberService(MemberRepository memberRepository) { this.memberRepository = memberRepository; }

    public void createMember(String name, String email) {
        if(name == null || name.isBlank()) throw new IllegalArgumentException("Name cannot be null or blank");
        if (email == null || email.isBlank()) throw new IllegalArgumentException("Email cannot be null or blank.");

        Member member = new Member(name.trim(), email.trim());
        memberRepository.save(member);
    }

    public Member getMember(Long id) {
        return memberRepository.findById(id);
    }

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public List<Member> getMembers() {
        return memberRepository.findAll();
    }

    public void updateMember(Member member) {
        memberRepository.update(member);
    }

    public void deleteMember(Member member) {
        memberRepository.delete(member);
    }
}
