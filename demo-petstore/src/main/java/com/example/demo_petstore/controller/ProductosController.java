package com.example.demo_petstore.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import  org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo_petstore.model.Productos;
import com.example.demo_petstore.service.ProductosService;



@Controller
@RequestMapping("/productos")
public class ProductosController {

    @Autowired
    ProductosService productosService;

    @GetMapping
    public String getAllProductos(Model model) {
        List<Productos> productos = productosService.findAll();
        model.addAttribute("productos", productos);        
        return "productos";
    }

    @GetMapping("/nuevo")
    public String addUserForm(Model model) {
        model.addAttribute("productos", new Productos());
        return "agregar-producto";
    }

    @PostMapping 
    public String createProductos(@ModelAttribute Productos productos){
        productosService.save(productos);         
        return "redirect:/productos";
    }

     @GetMapping("/editar/{id}")
       public String showEditForm(@PathVariable Long id, Model model) {
        Optional<Productos> productos = productosService.findById(id);
        if (productos.isPresent()){
            model.addAttribute("productos", productos.get());
            return "editar-productos";
            
         } else {
            return "redirect:/productos";

        }

    }
    @PostMapping ("/actualizar/{id}")
    public String updateProductos(@PathVariable Long id, @ModelAttribute Productos productosDetails) {
        Optional<Productos> optionalproductos = productosService.findById(id);
        if (optionalproductos.isPresent()){
            Productos productos = optionalproductos.get();
            productos.setNombre(productosDetails.getNombre());
            productos.setPrecio(productosDetails.getPrecio());
            productosService.save(productos);
            return "redirect:/productos";


        } else{
            return "redirect:/productos";    
        }

               
        
    }
    @GetMapping("/elimina/{id}")
       public String borrar(@PathVariable Long id) {
        productosService.eliminarporId(id);
        
        
            return "redirect:/productos";

      }  

    
   

}




