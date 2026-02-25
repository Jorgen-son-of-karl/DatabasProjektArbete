package com.karlsson.repo;

import com.karlsson.entity.Member;
import com.karlsson.exception.EntitySaveException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

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

    @Override
    public void update(Member member) {

        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();
            session.merge(member);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw new EntitySaveException(
                    "Member could not be updated: " + member.getClass().getSimpleName()
            );
        }
    }

    @Override
    public void delete(Member member) {

    }

    @Override
    public Member findById(int id) {
        return null;
    }

    @Override
    public List<Member> findAll() {
        return List.of();
    }
}
