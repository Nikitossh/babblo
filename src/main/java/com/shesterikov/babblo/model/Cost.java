package com.shesterikov.babblo.model;

import lombok.Data;

import javax.persistence.*;


@Entity(name = "costs")
@Table(name = "costs")
@Data
public class Cost {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "value")
    private Long value;

    @ManyToOne
    private Category category;

    @Basic(optional = false, fetch = FetchType.LAZY)
    private String comment;

    @ManyToOne
    private Date date;

    public Cost() {}

    public Cost(Long value, Category category, String comment, Date date) {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Cost{" +
                "id=" + id +
                ", value=" + value +
                ", category=" + category +
                ", comment='" + comment + '\'' +
                ", date=" + date +
                '}';
    }
}
