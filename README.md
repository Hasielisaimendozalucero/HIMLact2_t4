# Actividad 2: Spring MVC - Vistas con Thymeleaf, DTOs y Manejo de Peticiones

## Descripción
Proyecto desarrollado con Spring Boot y Thymeleaf que implementa el patrón MVC, mapeo de peticiones con `@RequestParam`, `@PathVariable`, lectura de propiedades dinámicas con `@Value`, formularios con `@ModelAttribute`, objetos DTO (`ProductoDTO`) y desplegado en un servidor VPS de Microsoft Azure[cite: 13, 14].

## Enlaces de Despliegue
- **URL pública VPS (Puerto 8083):** `http://20.98.89.81:8083/productos`
- **Repositorio GitHub:** `https://github.com/Hasielisaimendozalucero/HIMLact2_t4.git`

## Funcionalidades e Implementación
1. **Lista de Productos con Thymeleaf:** Visualización de elementos recorridos dinámicamente con `th:each`.
2. **Uso de `@Value`:** Inyección dinámica del nombre del proyecto en la interfaz desde `application.properties`.
3. **Filtro con `@RequestParam`:** Filtrado de productos por categoría mediante `/productos?categoria=Electronica`.
4. **Detalle con `@PathVariable`:** Consulta individual mediante `/productos/{id}`.
5. **Formulario `@ModelAttribute`:** Alta de nuevos registros redireccionando al catálogo.
6. **Endpoint REST POST:** Mapeo REST que procesa JSON y retorna una respuesta estructurada DTO.
