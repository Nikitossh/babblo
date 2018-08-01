package com.shesterikov.babblo.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

abstract class AbstractCost {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
}
