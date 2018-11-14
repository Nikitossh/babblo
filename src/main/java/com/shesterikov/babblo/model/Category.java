package com.shesterikov.babblo.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "category")
@Table(name = "category")
@Data
public class Category {
    @Id
    private long id;
    private String category;

}
