package com.karlsson.repo;

import com.karlsson.entity.Instrument;
import com.karlsson.entity.Member;
import com.karlsson.exception.EntitySaveException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class InstrumentRepositoryImpl implements InstrumentRepository {

    private final SessionFactory sessionFactory;

    public InstrumentRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Instrument instrument) {
        try (Session session = this.sessionFactory.openSession()) {
            var tx = session.beginTransaction();
            session.persist(instrument);
            tx.commit();
        }
    }

    @Override
    public void update(Instrument instrument) {
        Transaction tx = null;
        try (Session session = this.sessionFactory.openSession()) {
            tx = session.beginTransaction();
            session.merge(instrument);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw new EntitySaveException("The Instrument could not be updated: " + instrument.getClass().getSimpleName());
        }
    }

    @Override
    public void delete(Instrument instrument) {
        Transaction tx = null;
        try (Session session = this.sessionFactory.openSession()) {
            tx = session.beginTransaction();
            session.delete(instrument);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
        }
    }

    @Override
    public Instrument findById(Long id) {
        try (Session session = this.sessionFactory.openSession()) {
            return session.get(Instrument.class, id);
        }
    }

    @Override
    public List<Instrument> findAll() {
        try (Session session = this.sessionFactory.openSession()) {
            return session.createQuery("from Instrument", Instrument.class).list();
        }
    }
}
