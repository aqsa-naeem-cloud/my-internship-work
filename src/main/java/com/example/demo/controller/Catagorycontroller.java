package com.example.demo.controller;
import com.example.demo.service.Catagoryservice;
import com.example.demo.entity.catagory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/catagories")
public class Catagorycontroller{
    private final Catagoryservice catagoryservice;

    public Catagorycontroller(Catagoryservice catagoryservice)
    {
        this.catagoryservice = catagoryservice;
    }

    // POST /api/categories -> add a category
    @PostMapping
    public catagory addCategory(@RequestBody catagory cat)
    {
        return catagoryservice.addCategory(cat);
    }

    // GET /api/categories -> list all categories
    @GetMapping
    public List<catagory> getAllCategories()
    {
        return catagoryservice.getAllCategories();
    }
}
