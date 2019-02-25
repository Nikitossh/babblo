package com.shesterikoff.babblo.model;

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
}
