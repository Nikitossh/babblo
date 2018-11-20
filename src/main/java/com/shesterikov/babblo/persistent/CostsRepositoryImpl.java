package com.shesterikov.babblo.persistent;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CostsRepositoryImpl implements CostRepository{
    private static SessionFactory sessionFactory = createFactory();

    private static SessionFactory createFactory() {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
        return sessionFactory;
    }

    public List findAll() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from costs where id>0" );
        session.getTransaction().commit();

        return query.list();
    }

    public List findByCategory(String category) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from costs where category.category = :category");
        query.setParameter("category", category);
        session.getTransaction().commit();

        return query.list();
    }

    @Override
    public List findMonth(Integer month) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from costs where MONTH(date.date) = :month");
        query.setParameter("month", month);
        session.getTransaction().commit();

        return query.list();
    }

}
