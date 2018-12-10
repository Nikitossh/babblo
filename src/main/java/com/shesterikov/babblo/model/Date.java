package com.shesterikov.babblo.model;

import lombok.Data;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Entity (name = "date")
@Table (name = "date")
@Data
public class Date {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;

    public Date(String date) {
        this.date = LocalDate.parse(date);
    }

    public Date(LocalDate date) {
        this.date = date;
    }

    public Date() {
    }
}
