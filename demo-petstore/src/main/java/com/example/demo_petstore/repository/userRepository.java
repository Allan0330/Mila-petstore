package com.example.demo_petstore.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo_petstore.model.User; // Importa el modelo User
// Define una interfaz que extiende JpaRepository para manejar operaciones de la entidad User
public interface userRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);  // Método para buscar un usuario por su nombre de usuario
}

