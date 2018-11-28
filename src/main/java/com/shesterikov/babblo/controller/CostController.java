package com.shesterikov.babblo.controller;

import com.shesterikov.babblo.model.Category;
import com.shesterikov.babblo.model.Cost;
import com.shesterikov.babblo.persistent.CostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CostController {

    @Autowired
    CostRepository repository;

    @GetMapping("/costs")
    public List<Cost> getAllCosts() {
        List<Cost> costs = new ArrayList<>();
        repository.findAll().forEach(costs::add);

        return costs;
    }

    @PostMapping("cost")
    public Cost postCost(@RequestBody Cost cost) {
        Cost _cost = repository.save(new Cost(cost.getValue(), cost.getCategory(), cost.getComment(), cost.getDate()));
        return _cost;
    }

    @DeleteMapping("cost/{id}")
    public ResponseEntity<String> deleteCost(@PathVariable("id") long id) {
        repository.deleteById(id);
        return new ResponseEntity<>("Cost has been deleted!", HttpStatus.OK);
    }

    @GetMapping("/costs/category/{category}")
    public List<Cost> findCostByCategory(@PathVariable Category category) {
        List<Cost> costs = repository.findCostByCategory(category);
        return costs;
    }

    @PutMapping("/cost/{id}")
    public ResponseEntity<Cost> updateCost(@PathVariable("id") long id, @RequestBody Cost cost) {
        Optional<Cost> costData = repository.findById(id);
        if(costData.isPresent()) {
            Cost _cost = costData.get();
            _cost.setValue(cost.getValue());
            _cost.setCategory(cost.getCategory());
            _cost.setComment(cost.getComment());
            _cost.setDate(cost.getDate());
            return new ResponseEntity<>(repository.save(_cost), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
