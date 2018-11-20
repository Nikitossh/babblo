package com.shesterikov.babblo.persistent;

import com.shesterikov.babblo.model.Cost;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CostRepository {
    List findAll();
    List findByCategory(String category);
    List findMonth(Integer month);
}
