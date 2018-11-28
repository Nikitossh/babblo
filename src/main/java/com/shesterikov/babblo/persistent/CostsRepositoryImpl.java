//package com.shesterikov.babblo.persistent;
//
//import com.shesterikov.babblo.model.Cost;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.boot.MetadataSources;
//import org.hibernate.boot.registry.StandardServiceRegistry;
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//import org.hibernate.query.Query;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public class CostsRepositoryImpl implements CostRepositoryOld {
//    private static SessionFactory sessionFactory = createFactory();
//
//    private static SessionFactory createFactory() {
//        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
//                .configure() // configures settings from hibernate.cfg.xml
//                .build();
//        try {
//            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
//        } catch (Exception e) {
//            StandardServiceRegistryBuilder.destroy(registry);
//        }
//        return sessionFactory;
//    }
//
//    // Find all costs in table and return as List
//    public List findAll() {
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//        Query query = session.createQuery("from costs where id>0" );
//        session.getTransaction().commit();
//
//        return query.list();
//    }
//
//    // Find all entrees by one category and return as List
//    public List findByCategory(String category) {
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//        Query query = session.createQuery("from costs where category.category = :category");
//        query.setParameter("category", category);
//        session.getTransaction().commit();
//
//        return query.list();
//    }
//
//    // Find entrees in selected ONE month and return List with only category and SUM(value)
//    //todo: In this method YEAR is hardcoded, think what to do with it
//    @Override
//    public List findMonth(Integer month) {
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//        Query query = session.createQuery("select category.category as c, sum(value) as s " +
//                "from costs " +
//                "where MONTH(date.date) = :month and YEAR(date.date) = :year " +
//                "group by category.category");
//        query.setParameter("month", month);
//        query.setParameter("year", 2018);
//        session.getTransaction().commit();
//
//        return query.list();
//    }
//
//    // Insert ONE cost to table
//    public void insertCost(Cost cost) {
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//        session.save(cost);
//        session.getTransaction().commit();
//    }
//
//}
