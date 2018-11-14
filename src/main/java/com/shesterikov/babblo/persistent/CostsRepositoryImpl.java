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


    public List findBy() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from costs where id< :id and category.category=:cat" );
        query.setParameter("id", (long) 22);
        query.setParameter("cat", "food");
        session.getTransaction().commit();

    return query.list();
    }

}
