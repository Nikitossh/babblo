package com.shesterikov.babblo.model;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "category")
@Table(name = "category")
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String category;

    public Category(String category) {
        this.category = category;
    }

    public Category() {
    }
}
