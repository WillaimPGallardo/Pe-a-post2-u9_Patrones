package com.universidad.productos_service.controller;

import com.universidad.productos_service.domain.Producto;
import com.universidad.productos_service.service.ProductoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public List<Producto> listarProductos() {
        return productoService.listarProductos();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Producto crearProducto(
            @RequestBody Producto producto
    ) {

        return productoService.guardarProducto(producto);
    }

    @GetMapping("/{id}")
    public Producto buscarProducto(
            @PathVariable Long id
    ) {

        return productoService.buscarProductoPorId(id);
    }

    @PutMapping("/{id}")
    public Producto actualizarProducto(
            @PathVariable Long id,
            @RequestBody Producto producto
    ) {

        return productoService.actualizarProducto(
                id,
                producto
        );
    }

    @DeleteMapping("/{id}")
    public void eliminarProducto(
            @PathVariable Long id
    ) {

        productoService.eliminarProducto(id);
    }
}