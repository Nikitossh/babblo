package com.shesterikov.babblo.controller;

import com.shesterikov.babblo.model.Cost;
import com.shesterikov.babblo.persistent.CostsRep;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

    @CrossOrigin(origins = "http://localhost:8080")
    @RequestMapping("/")
    public @ResponseBody List<Cost> index() {
        return CostsRep.getCosts();
    }

}
