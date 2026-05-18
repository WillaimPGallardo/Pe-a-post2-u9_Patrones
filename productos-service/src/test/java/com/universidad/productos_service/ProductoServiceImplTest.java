package com.universidad.productos_service;

import com.universidad.productos_service.domain.Producto;
import com.universidad.productos_service.repository.ProductoRepository;
import com.universidad.productos_service.service.ProductoServiceImpl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProductoServiceImplTest {

    @Mock
    private ProductoRepository productoRepository;

    @InjectMocks
    private ProductoServiceImpl producto_Service;

    @Test
    void crearProductoCorrectamente() {

        Producto producto =
                new Producto(
                        1L,
                        "Laptop",
                        1500.0,
                        10
                );

        when(productoRepository.save(any(Producto.class)))
                .thenReturn(producto);

        Producto resultado =
                producto_Service.crear(
                        "Laptop",
                        1500.0,
                        10
                );

        assertNotNull(resultado);

        assertEquals(
                "Laptop",
                resultado.getNombre()
        );

        verify(productoRepository)
                .save(any(Producto.class));
    }

    @Test
    void crearProductoConNombreVacio() {

        Exception exception =
                assertThrows(
                        IllegalArgumentException.class,
                        () -> {
                            producto_Service.crear(
                                    "",
                                    100.0,
                                    5
                            );
                        }
                );

        assertEquals(
                "El nombre no puede estar vacío",
                exception.getMessage()
        );
    }

    @Test
    void buscarProductoExistente() {

        Producto producto =
                new Producto(
                        1L,
                        "Mouse",
                        50.0,
                        20
                );

        when(productoRepository.findById(1L))
                .thenReturn(Optional.of(producto));

        Producto resultado =
                producto_Service.buscarPorId(1L);

        assertEquals(
                "Mouse",
                resultado.getNombre()
        );
    }

    @Test
    void buscarProductoNoExistente() {

        when(productoRepository.findById(99L))
                .thenReturn(Optional.empty());

        assertThrows(
                RuntimeException.class,
                () -> {
                    producto_Service.buscarPorId(99L);
                }
        );
    }

    @Test
    void actualizarStockCorrectamente() {

        Producto producto =
                new Producto(
                        1L,
                        "Teclado",
                        80.0,
                        10
                );

        when(productoRepository.findById(1L))
                .thenReturn(Optional.of(producto));

        when(productoRepository.save(any(Producto.class)))
                .thenReturn(producto);

        Producto actualizado =
                producto_Service.actualizarStock(
                        1L,
                        25
                );

        assertEquals(
                25,
                actualizado.getStock()
        );
    }

    @Test
    void eliminarProducto() {

        Producto producto =
                new Producto(
                        1L,
                        "Monitor",
                        900.0,
                        5
                );

        when(productoRepository.findById(1L))
                .thenReturn(Optional.of(producto));

        doNothing()
                .when(productoRepository)
                .deleteById(1L);

        producto_Service.eliminar(1L);

        verify(productoRepository)
                .deleteById(1L);
    }
}