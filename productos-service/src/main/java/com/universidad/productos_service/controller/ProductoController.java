package com.universidad.productos_service.controller;

import com.universidad.productos_service.domain.Producto;
import com.universidad.productos_service.service.ProductoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @PostMapping
    public Producto crear(@RequestBody Producto producto) {

        return productoService.crear(
                producto.getNombre(),
                producto.getPrecio(),
                producto.getStock()
        );
    }

    @GetMapping("/{id}")
    public Producto buscar(@PathVariable Long id) {

        return productoService.buscarPorId(id);
    }
}