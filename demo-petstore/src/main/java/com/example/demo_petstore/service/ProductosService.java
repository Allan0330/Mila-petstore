package com.example.demo_petstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import  org.springframework.stereotype.Service;

import com.example.demo_petstore.model.Productos;
import com.example.demo_petstore.repository.ProductosRepository;

@Service
public class ProductosService {

    @Autowired
    private ProductosRepository productosRepository;

    public List<Productos> findAll(){
    return productosRepository.findAll();
    }

    public Optional<Productos> findById(Long id){
        return productosRepository.findById(id);
    }

    public Productos save (Productos productos){
        return productosRepository.save(productos);
    }

    public void eliminarporId(Long id){
        productosRepository.deleteById(id);
    }
}
