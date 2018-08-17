package com.shesterikov.babblo.persistent;

import com.shesterikov.babblo.model.Cost;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CostsRepositoryImpl implements CostRepository{
    private static SessionFactory sessionFactory;

    public List<Cost> findBy() {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    Session session = sessionFactory.openSession();
    Query query = session.createQuery(
            "select c " +
                    "from costs c ");
        session.beginTransaction();
        return query.list();
    }

    @Override
    public <S extends Cost> S save(S s) {
        return null;
    }

    @Override
    public <S extends Cost> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Cost> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Cost> findAll() {
        return null;
    }

    @Override
    public Iterable<Cost> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Cost cost) {

    }

    @Override
    public void deleteAll(Iterable<? extends Cost> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
