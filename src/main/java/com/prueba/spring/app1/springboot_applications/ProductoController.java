package com.prueba.spring.app1.springboot_applications;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/productos")
public class ProductoController {

    @Value("${app.nombre-proyecto}")
    private String nombreProyecto;

    private List<ProductoDTO> listaProductos = new ArrayList<>();

    public ProductoController() {
        listaProductos.add(new ProductoDTO(1L, "Laptop Dell", 15000.0, "Electronica"));
        listaProductos.add(new ProductoDTO(2L, "Teclado Mecanico", 1200.0, "Accesorios"));
        listaProductos.add(new ProductoDTO(3L, "Monitor 24 pulgadas", 3500.0, "Electronica"));
    }

    // Vista 1: Mostrar lista (con th:each y filtro por @RequestParam)
    @GetMapping
    public String listarProductos(@RequestParam(required = false) String categoria, Model model) {
        List<ProductoDTO> filtrados = listaProductos;
        if (categoria != null && !categoria.isEmpty()) {
            filtrados = listaProductos.stream()
                    .filter(p -> p.getCategoria().equalsIgnoreCase(categoria))
                    .collect(Collectors.toList());
        }
        model.addAttribute("productos", filtrados);
        model.addAttribute("nombreProyecto", nombreProyecto);
        return "lista-productos";
    }

    // Vista con @PathVariable para ver detalle por ID
    @GetMapping("/{id}")
    public String verDetalle(@PathVariable Long id, Model model) {
        ProductoDTO producto = listaProductos.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
        model.addAttribute("producto", producto);
        model.addAttribute("nombreProyecto", nombreProyecto);
        return "detalle-producto";
    }

    // Vista 2: Formulario para agregar producto
    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("productoDTO", new ProductoDTO());
        model.addAttribute("nombreProyecto", nombreProyecto);
        return "formulario-producto";
    }

    // Procesar formulario con @ModelAttribute
    @PostMapping("/guardar")
    public String guardarProducto(@ModelAttribute ProductoDTO productoDTO) {
        productoDTO.setId((long) (listaProductos.size() + 1));
        listaProductos.add(productoDTO);
        return "redirect:/productos";
    }

    // Endpoint POST REST que devuelve JSON (probado con Postman)
    @PostMapping("/api/crear")
    @ResponseBody
    public ProductoDTO crearProductoRest(@RequestBody ProductoDTO dto) {
        dto.setId((long) (listaProductos.size() + 1));
        listaProductos.add(dto);
        return dto;
    }
}