package com.wigell.repo;

import com.wigell.entity.Member;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class MemberRepositoryImpl implements MemberRepository {

    private final SessionFactory sessionFactory;

    public MemberRepositoryImpl(SessionFactory sessionFactory) {this.sessionFactory = sessionFactory;}

    @Override
    public void save(Member member) {
        try (Session session = sessionFactory.openSession()) {
            var tx = session.beginTransaction();
            session.persist(member);
            tx.commit();
        }
    }
}
