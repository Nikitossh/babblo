package com.shesterikov.babblo.persistent;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

public class CostsRepositoryImplTest {
    private static SessionFactory sessionFactory;

    @BeforeAll
    static void init() {
        System.out.println("Let's go testing!");
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    @Test
    public void findBy() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(
                "select c " +
                        "from costs c ");
        session.beginTransaction();
    }

    @AfterAll
    static void done() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}
