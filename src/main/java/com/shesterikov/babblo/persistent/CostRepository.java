package com.shesterikov.babblo.persistent;

import com.shesterikov.babblo.model.Cost;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CostRepository extends CrudRepository<Cost, Long> {
    public List<Cost> findBy();
}
