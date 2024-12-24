package com.example.demo_petstore.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
// Indica que esta clase es una entidad JPA, lo que significa que será mapeada a una tabla en la base de datos
@Entity
public class Productos {
    
    @Id   //  la clave primaria de la tabla en la base de datos
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private int precio;

      // Getters and setters
      public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }
 
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
 
 
    public int  getPrecio() {
        return precio;
    }

  public void setPrecio(int precio) {
        this.precio = precio;
    }

}


