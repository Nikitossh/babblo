package com.shesterikov.babblo.controller;

import com.shesterikov.babblo.persistent.CostRepository;
import com.shesterikov.babblo.persistent.CostsRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

import static java.time.LocalDate.*;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class CostController {

    @Autowired
    CostRepository costRepository = new CostsRepositoryImpl();

    @RequestMapping("/")
    public @ResponseBody
    List index() {
        return costRepository.findAll();
    }

    @RequestMapping("/category")
    public @ResponseBody
    List category(@RequestParam(value = "category", defaultValue = "") String category) {
        return costRepository.findByCategory(category);
    }

    @RequestMapping("/month")
    public @ResponseBody
    List month(@RequestParam(value = "month") Integer month) {
        return costRepository.findMonth(month);
    }
}
