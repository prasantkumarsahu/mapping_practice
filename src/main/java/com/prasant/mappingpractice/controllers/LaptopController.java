package com.prasant.mappingpractice.controllers;

import com.prasant.mappingpractice.models.Laptop;
import com.prasant.mappingpractice.services.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("laptop")
public class LaptopController {

    @Autowired
    private LaptopService laptopService;

    @PostMapping()
    public String createLaptop(@RequestBody Laptop laptop){
        return laptopService.saveLaptop(laptop);
    }

    @GetMapping()
    public List<Laptop> getAllLaptops(){
        return laptopService.getAllLaptops();
    }

    @PutMapping("{lapId}")
    public String updateLaptop(@PathVariable String lapId, @RequestBody Laptop laptop){
        return laptopService.updateLaptopById(lapId, laptop);
    }

    @DeleteMapping("{laptopId}")
    public String deleteLaptop(@PathVariable String laptopId){
        return laptopService.deleteLaptopById(laptopId);
    }
}
