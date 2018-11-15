package com.shesterikov.babblo.controller;

import com.shesterikov.babblo.persistent.CostRepository;
import com.shesterikov.babblo.persistent.CostsRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class HelloController {
    @Autowired
    CostRepository costRepository = new CostsRepositoryImpl();

    @RequestMapping("/")
    public @ResponseBody
    List index() {
        return costRepository.findAll();
    }

    @RequestMapping("/category")
    public @ResponseBody
    List category(@RequestParam(value = "category", defaultValue = "other") String category) {
        return costRepository.findByCategory(category);
    }

}
