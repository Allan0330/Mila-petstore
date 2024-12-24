package com.example.demo_petstore.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class GenerarContrasena {

     public static void main(String[] args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        
        String hashedPassword = passwordEncoder.encode("lazy");
        System.out.println("Contrasena encriptada: " + hashedPassword);

       
    }
    
}
