package com.shesterikov.babblo.persistent;

import com.shesterikov.babblo.model.Category;
import com.shesterikov.babblo.model.Cost;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CostRepository extends CrudRepository<Cost, Long> {
    List<Cost> findCostByCategory(Category category);
}
