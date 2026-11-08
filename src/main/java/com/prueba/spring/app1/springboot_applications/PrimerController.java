package com.prueba.spring.app1.springboot_applications;
//package com.prueba.spring.app1.springboot_applications;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrimerController {

    // Endpoint 1: Identificador del estudiante
    @GetMapping("/mi-nombre")
    public String obtenerNombre() {
        return "Proyecto Spring Boot - Creado por Hasiel lucero";
    }
}