package com.universidad.productos_service;

import com.universidad.productos_service.domain.Producto;
import com.universidad.productos_service.repository.ProductoRepository;
import com.universidad.productos_service.service.ProductoServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

class ProductoServiceImplTest {

    @Mock
    private ProductoRepository productoRepository;

    @InjectMocks
    private ProductoServiceImpl productoService;

    private Producto producto;

    @BeforeEach
    void setUp() {

        MockitoAnnotations.openMocks(this);

        producto = new Producto(
                1L,
                "Laptop",
                1500.0,
                10
        );
    }

    @Test
    void listarProductos_retornaLista() {

        when(productoRepository.findAll())
                .thenReturn(List.of(producto));

        List<Producto> productos =
                productoService.listarProductos();

        assertEquals(1, productos.size());

        verify(productoRepository, times(1))
                .findAll();
    }

    @Test
    void guardarProducto_retornaProductoGuardado() {

        when(productoRepository.save(producto))
                .thenReturn(producto);

        Producto resultado =
                productoService.guardarProducto(producto);

        assertNotNull(resultado);

        assertEquals("Laptop", resultado.getNombre());

        verify(productoRepository, times(1))
                .save(producto);
    }

    @Test
    void buscarProductoPorId_existente_retornaProducto() {

        when(productoRepository.findById(1L))
                .thenReturn(Optional.of(producto));

        Producto resultado =
                productoService.buscarProductoPorId(1L);

        assertNotNull(resultado);

        assertEquals(1L, resultado.getId());

        verify(productoRepository, times(1))
                .findById(1L);
    }

    @Test
    void eliminarProducto_llamaRepository() {

        doNothing()
                .when(productoRepository)
                .deleteById(1L);

        productoService.eliminarProducto(1L);

        verify(productoRepository, times(1))
                .deleteById(1L);
    }
}