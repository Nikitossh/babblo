package com.shesterikoff.babblo.persistent;

import com.shesterikoff.babblo.model.Cost;

import java.util.List;

public interface CostRepository {
    List findAll();
    List findByCategory(String category);
    List findMonth(Integer month);
    void insertCost(Cost cost);
}
