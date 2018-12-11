package com.shesterikov.babblo.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;


@Entity(name = "costs")
@Table(name = "newcosts")
@Data
public class Cost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "value")
    private Long value;

    @ManyToOne(cascade = {CascadeType.ALL})
    private Category category;

    @Basic(optional = false, fetch = FetchType.LAZY)
    private String comment;

//    @ManyToOne(cascade = {CascadeType.ALL})
    @Column(name = "date")
    private LocalDate date;

    public Cost() {}

    public Cost(Long value, Category category, String comment, LocalDate date) {
        this.value = value;
        this.category = category;
        this.comment = comment;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate localDate) {
        this.date = localDate;
    }

    @Override
    public String toString() {
        return "Cost{" +
                "id=" + id +
                ", value=" + value +
                ", category=" + category +
                ", comment='" + comment + '\'' +
                ", localDate=" + date +
                '}';
    }
}
