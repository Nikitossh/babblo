package com.shesterikov.babblo.persistent;

import com.shesterikov.babblo.model.Cost;
import org.springframework.data.repository.CrudRepository;

public interface CostRepository extends CrudRepository<Cost, Long> {
}
