package com.example.demo_petstore.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity // Marca esta clase como una entidad de base de datos
@Table(name = "app_usuario") // Define el nombre de la tabla en la base de datos
public class User {
    @Id // Define la clave primaria de la entidad
    @GeneratedValue(strategy=GenerationType.IDENTITY) // Indica que el valor de este campo se generará automáticamente
    private Long id; 
    
    private String username; 
    private String password; 
    private String role; // Rol del usuario (por ejemplo, admin, user)

    public Long getId(){  // Método para obtener el id del usuario
        return id;
    }

    public void setId(Long id){// Método para establecer el id del usuario
        this.id = id; 
    }

    public String getNombreUsuario(){
        return username;
    }

    public void setNombreUsuario(String username){
        this.username = username;
    }

    public String getContrasena(){
        return password;
    }

    public void setcontrasena(String contrasena){
        this.password = contrasena;
    }

    public String getRole(){
        return role;
    }

    public void setRole(String role){
        this.role = role;
    }

    
}
