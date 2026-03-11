package com.karlsson;

import com.karlsson.entity.Member;
import com.karlsson.repo.MemberRepository;
import com.karlsson.repo.MemberRepositoryImpl;
import com.karlsson.service.MemberService;
import com.karlsson.util.HibernateUtil;
import org.hibernate.SessionFactory;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();




        MemberRepository memberRepository = new MemberRepositoryImpl(sessionFactory);

        MemberService memberService = new MemberService(memberRepository);
        System.out.println("Hibernate started!");


//        memberService.createMember("Perkele", "hallå");

        Member m = memberService.getMember(3L);
        System.out.println(m.getName() + " " + m.getEmail());

        List<Member> members = memberService.getAllMembers();
        for (Member member : members) {
            System.out.println(member.getName());
        }

        memberService.deleteMember(m);

        members = memberService.getAllMembers();
        for (Member member : members) {
            System.out.println(member.getName());
        }

//        m.setName("Arne Karlsson");
//        memberService.updateMember(m);
//
//        m = memberService.getMember(1L);
//        System.out.println(m.getName() + " " + m.getEmail());



    }
}