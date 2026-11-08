package com.prueba.spring.app1.springboot_applications;

//package com.prueba.spring.app1.springboot_applications;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Arrays;

@RestController
public class SegundoController {

    // Endpoint 2: Lista simulada
    @GetMapping("/materias")
    public List<String> obtenerMaterias() {
        return Arrays.asList("Programación Web", "Conmutación ", "Bases de Datos");
    }

    // Endpoint 3: Respuesta simple
    @GetMapping("/estado")
    public String obtenerEstado() {
        return "Servidor local corriendo correctamente en el puerto 8080";
    }
}