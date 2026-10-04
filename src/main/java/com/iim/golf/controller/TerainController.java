package com.iim.golf.controller;

import com.iim.golf.model.Terain;
import com.iim.golf.service.AddTerainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/terain")
public class TerainController {

    private final AddTerainService addTerainService;

    @Autowired
    public TerainController(AddTerainService addTerainService) {
        this.addTerainService = addTerainService;
    }

    @PostMapping("/add")
    public Terain create(@RequestBody Terain terain) {
        return addTerainService.create(terain);
    }

    @GetMapping("/get")
    public Terain getById(@RequestParam int id) {
        return addTerainService.getById(id);
    }
}
