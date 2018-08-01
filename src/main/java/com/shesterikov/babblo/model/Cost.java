package com.shesterikov.babblo.model;

import javax.persistence.*;


@Entity(name = "costs")
@Table(name = "costs")
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

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
