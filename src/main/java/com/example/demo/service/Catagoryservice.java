package com.example.demo.service;
import com.example.demo.entity.catagory;
import com.example.demo.repository.Catagoryrepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Catagoryservice {

    private final Catagoryrepository catagoryrepository;

    public Catagoryservice(Catagoryrepository catagoryrepository) {
        this.catagoryrepository = catagoryrepository;
    }

    public catagory addCategory(catagory cat) {
        return catagoryrepository.save(cat);
    }

    public List<catagory> getAllCategories() {
        return catagoryrepository.findAll();
    }
}
