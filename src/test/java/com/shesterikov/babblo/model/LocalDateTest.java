//package com.shesterikov.babblo.model;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.boot.MetadataSources;
//import org.hibernate.boot.registry.StandardServiceRegistry;
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//import org.hibernate.query.Query;
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//
//import java.util.Arrays;
//import java.util.List;
//
//class LocalDateTest {
//    private static SessionFactory sessionFactory;
//
//    @BeforeAll
//    static void init() {
//        System.out.println("Let's go!");
//        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
//                .configure() // configures settings from hibernate.cfg.xml
//                .build();
//        try {
//            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
//        } catch (Exception e) {
//            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
//            // so destroy it manually.
//            StandardServiceRegistryBuilder.destroy(registry);
//        }
//    }
//
//    @AfterAll
//    static void done() {
//        if (sessionFactory != null) {
//            sessionFactory.close();
//        }
//    }
//
////    @Test
////    @SuppressWarnings({"unchecked"})
////    void testBasicUsage() {
////        Session session = sessionFactory.openSession();
////        session.beginTransaction();
////        // Name "date" in database with lowercase must be the same there
////        List result = session.createQuery("from date ").list();
////        for (LocalDate d  : (List<LocalDate>) result) {
////            System.out.println(d.getDate().toString());
////        }
////        session.getTransaction().commit();
////        session.close();
////    }
//
//    @Test
//    @SuppressWarnings("unchecked")
//    void testSelectSomeCosts() {
//        Session session = sessionFactory.openSession();
//        Query query = session.createQuery(
//                "select c " +
//                        "from costs c " +
//                        "where c.comment like :comment")
//                .setParameter("comment", "s%");
//        session.beginTransaction();
//        List result = query.list();
//        for (Cost cost : (List<Cost>) result) {
//            System.out.println(cost.getId() + " " + cost.getValue() + " " + cost.getCategory() + " " + cost.getComment());
//        }
//        session.getTransaction().commit();
//        session.close();
//    }
//
//    @Test
//    @SuppressWarnings("unchecked")
//        // NativeQuery
//    void testGetMonthCosts() {
//        Session session = sessionFactory.openSession();
//        List<Object[]> costs = session.createNativeQuery("SELECT category.category, SUM(costs.value) AS value\n" +
//                "FROM costs\n" +
//                "INNER JOIN category ON costs.category_id=category.id\n" +
//                "INNER JOIN date ON costs.date_id=date.id\n" +
//                "WHERE MONTH(date)=MONTH(NOW())\n" +
//                "AND YEAR(date)=YEAR(NOW())\n" +
//                "GROUP BY category;").getResultList();
//        session.beginTransaction();
//        for (Object[] objects : costs) {
//            System.out.println(Arrays.toString(objects));
//        }
//        session.getTransaction().commit();
//        session.close();
//    }
//
//}
