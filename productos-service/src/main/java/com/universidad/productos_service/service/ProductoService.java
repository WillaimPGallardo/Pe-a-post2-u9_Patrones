package com.universidad.productos_service.service;

import com.universidad.productos_service.domain.Producto;

import java.util.List;

public interface ProductoService {

    List<Producto> listarProductos();

    Producto guardarProducto(Producto producto);

    Producto buscarProductoPorId(Long id);

    Producto actualizarProducto(Long id, Producto producto);

    void eliminarProducto(Long id);
}