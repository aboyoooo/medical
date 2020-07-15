package com.ncu.drug.controller;

import com.ncu.drug.pojo.Drug;
import com.ncu.drug.service.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DrugController {
    @Autowired
    private DrugService drugService;

    @GetMapping("/drug/{id}")
    public Drug queryById(@PathVariable Long id) { return drugService.queryById(id);}



}
