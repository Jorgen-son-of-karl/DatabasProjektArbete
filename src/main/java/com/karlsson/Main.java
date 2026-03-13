package com.karlsson;

import com.karlsson.entity.Member;
import com.karlsson.repo.InstrumentRepository;
import com.karlsson.repo.InstrumentRepositoryImpl;
import com.karlsson.repo.MemberRepository;
import com.karlsson.repo.MemberRepositoryImpl;
import com.karlsson.service.InstrumentService;
import com.karlsson.service.MemberService;
import com.karlsson.util.HibernateUtil;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();


        MemberRepository memberRepository = new MemberRepositoryImpl(sessionFactory);
        InstrumentRepository instrumentRepository = new InstrumentRepositoryImpl(sessionFactory);

        MemberService memberService = new MemberService(memberRepository);
        InstrumentService instrumentService = new InstrumentService(instrumentRepository);
        System.out.println("Hibernate started!");


        System.out.println("welcome to the instrument rental store!");
        boolean running = true;

        while (running) {
            System.out.println();
            System.out.println("Please select what you want to do from the list bellow: ");
            System.out.println("1. List all members");
            System.out.println("2. Create a new member");
            System.out.println("3. Update existing member");
            System.out.println("4. Delete existing member");
            System.out.println("5. List all instruments");
            System.out.println("6. Add a new instrument to stock");
            System.out.println("7. Update existing instrument");
            System.out.println("8. Delete existing instrument");
            Scanner userInput = new Scanner(System.in);

                switch (userInput.nextInt()) {
                    case 1:
                        memberService.listAllMembers();
                        break;
                    case 2:
                        memberService.createMember(userInput);
                        break;
                    case 3:
                        memberService.updateMember(userInput);
                        break;
                    case 4:
                        memberService.deleteMember(userInput);
                        break;
                    case 5:
                        instrumentService.listAllInstruments();
                        break;
                    case 6:
                        instrumentService.createInstrument(userInput);
                        break;
                    case 7:
                        instrumentService.updateInstrument(userInput);
                        break;
                    case 8:
                        instrumentService.deleteInstrument(userInput);
                        break;
                }
        }
    }
}