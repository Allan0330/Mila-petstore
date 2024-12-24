package com.example.demo_petstore.controller;

import org.springframework.stereotype.Controller;// Importa la anotación Controller de Spring
import org.springframework.web.bind.annotation.GetMapping; // Importa la anotación GetMapping de Spring


@Controller // Indica que esta clase es un controlador en la aplicación
public class HomeController {

    @GetMapping("/")  // Mapea la URL raíz ("/") a este método
    public String home(){
      return "home";  // Devuelve el nombre de la vista "home"
    }

    @GetMapping("/login")// Mapea la URL "/login" a este método
    public String login() {
        return "login";  // Devuelve el nombre de la vista "login"
    }
    
    
}
