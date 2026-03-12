package com.karlsson.service;

import com.karlsson.entity.Member;
import com.karlsson.repo.MemberRepository;

import java.util.List;
import java.util.Scanner;

public class MemberService {

    private final MemberRepository memberRepository;
    public MemberService(MemberRepository memberRepository) { this.memberRepository = memberRepository; }

    public void createMember(Scanner userInput) {
        userInput.nextLine();
        System.out.println("Please enter the members full name: ");
        String name = userInput.nextLine();
        System.out.println("Please enter the members email: ");
        String email = userInput.nextLine();
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

    public void listAllMembers() {
        List<Member> members = getAllMembers();
        for (Member member : members) {
            System.out.println(member.getName() + ", " + member.getEmail());
        }
    }

    public List<Member> getMembers() {
        return memberRepository.findAll();
    }

    public void updateMember(Scanner userInput) {
        userInput.nextLine();
        System.out.println("Which member would you like to update?");
        Member member = chooseMemberFromList(userInput);

        //TODO logic for choosing which field to update

        System.out.println("Please enter new full name: ");
        String name = userInput.nextLine();
        member.setName(name);
        System.out.println("Please enter new email: ");
        String email = userInput.nextLine();
        member.setEmail(email);

        memberRepository.update(member);
    }

    public void deleteMember(Scanner userInput) {
        userInput.nextLine();
        System.out.println("Which member would you like to delete?");
        Member member = chooseMemberFromList(userInput);
        System.out.println("WARNING!!! Are you sure you want to delete this member? Y/N");
        if(userInput.nextLine().equals("Y") || userInput.nextLine().equals("y")) {
            memberRepository.delete(member);
            System.out.println("Member successfully deleted!");
        }
        else {
            System.out.println("Deletion aborted.");
        }
    }

    //reusing functionality to choose a member from a list
    private Member chooseMemberFromList(Scanner userInput) {
        List<Member> members = memberRepository.findAll();
        for (int i = 0; i < members.size(); i++) {
            System.out.println(i + 1 + ". " + members.get(i).getName() + ", " + members.get(i).getEmail());
        }
        return members.get(userInput.nextInt() -1);
    }
}
