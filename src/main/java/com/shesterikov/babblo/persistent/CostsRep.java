package com.shesterikov.babblo.persistent;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.List;

public class CostsRep {
    private static SessionFactory sessionFactory;

    public static List getCosts() {
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
//                    "where c.comment like :comment")
//            .setParameter("comment", "s%");
        session.beginTransaction();
        return query.list();
    }
}
