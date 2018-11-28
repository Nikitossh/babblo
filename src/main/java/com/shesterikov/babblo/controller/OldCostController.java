//package com.shesterikov.babblo.controller;
//
//import com.shesterikov.babblo.persistent.CostRepositoryOld;
//import com.shesterikov.babblo.persistent.CostsRepositoryImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//
//@RestController
//@CrossOrigin(origins = "http://localhost:8080")
//public class OldCostController {
//
//    @Autowired
//    CostRepositoryOld costRepositoryOld = new CostsRepositoryImpl();
//
//    @RequestMapping("/")
//    public @ResponseBody
//    List index() {
//        return costRepositoryOld.findAll();
//    }
//
//    @RequestMapping("/category")
//    public @ResponseBody
//    List category(@RequestParam(value = "category", defaultValue = "") String category) {
//        return costRepositoryOld.findByCategory(category);
//    }
//
//    @RequestMapping("/month")
//    public @ResponseBody
//    List month(@RequestParam(value = "month", defaultValue = "") Integer month) {
//        return costRepositoryOld.findMonth(month);
//    }
////
////    @RequestMapping("/addcost")
////    public @ResponseBody
////    Cost insertCost(@RequestParam())
//}
