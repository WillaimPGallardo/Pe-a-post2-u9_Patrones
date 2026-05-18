package com.universidad.productos_service.service;

import com.universidad.productos_service.domain.Producto;
import com.universidad.productos_service.repository.ProductoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Producto guardarProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Producto buscarProductoPorId(Long id) {
        return productoRepository.findById(id)
                .orElse(null);
    }

    @Override
    public Producto actualizarProducto(Long id, Producto producto) {

        Producto existente = productoRepository.findById(id)
                .orElse(null);

        if (existente != null) {
            existente.setNombre(producto.getNombre());
            existente.setPrecio(producto.getPrecio());
            existente.setStock(producto.getStock());

            return productoRepository.save(existente);
        }

        return null;
    }

    @Override
    public void eliminarProducto(Long id) {
        productoRepository.deleteById(id);
    }
}