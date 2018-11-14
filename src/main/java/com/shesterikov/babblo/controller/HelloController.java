package com.shesterikov.babblo.controller;

import com.shesterikov.babblo.persistent.CostRepository;
import com.shesterikov.babblo.persistent.CostsRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {
    @Autowired
    CostRepository costRepository = new CostsRepositoryImpl();

    @CrossOrigin(origins = "http://localhost:8080")
    @RequestMapping("/")
    public @ResponseBody
    List index() {
        return costRepository.findBy();
//        return costRepository.fiii();
    }

}
