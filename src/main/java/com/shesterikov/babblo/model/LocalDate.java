//package com.shesterikov.babblo.model;
//
//import lombok.Data;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.boot.MetadataSources;
//import org.hibernate.boot.registry.StandardServiceRegistry;
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//import org.hibernate.query.Query;
//
//import javax.persistence.*;
//import java.time.LocalDate;
//import java.util.Arrays;
//import java.util.List;
//
//@Entity (name = "date")
//@Table (name = "date")
//@Data
//public class LocalDate {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private java.time.LocalDate date;
//
//    public LocalDate(String date) {
//        this.date = java.time.LocalDate.parse(date);
//    }
//
//    public LocalDate(java.time.LocalDate date) {
//        this.date = date;
//    }
//
//    public LocalDate() {
//    }
//}
