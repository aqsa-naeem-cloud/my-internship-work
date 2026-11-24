package com.example.demo.repository;

import com.example.demo.entity.catagory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Catagoryrepository extends JpaRepository<catagory, Long> {
}
