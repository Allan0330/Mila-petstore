package com.example.demo_petstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo_petstore.model.Productos;

@Repository
public interface  ProductosRepository extends JpaRepository<Productos, Long> {
    
}
