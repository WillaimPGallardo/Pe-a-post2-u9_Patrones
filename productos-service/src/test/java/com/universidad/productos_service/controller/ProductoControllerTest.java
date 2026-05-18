package com.universidad.productos_service.controller;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.universidad.productos_service.domain.Producto;
import com.universidad.productos_service.service.ProductoService;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.http.MediaType;

import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProductoController.class)
class ProductoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ProductoService productoService;

    @Test
    void listarProductos_retorna200ConLista() throws Exception {

        List<Producto> productos = List.of(
                new Producto(1L, "Laptop", 1500.0, 10),
                new Producto(2L, "Mouse", 50.0, 100)
        );

        when(productoService.listarProductos())
                .thenReturn(productos);

        mockMvc.perform(get("/api/productos"))

                .andExpect(status().isOk())

                .andExpect(jsonPath("$.length()").value(2))

                .andExpect(jsonPath("$[0].nombre")
                        .value("Laptop"));
    }

    @Test
    void crearProducto_datosValidos_retorna201()
            throws Exception {

        Producto producto =
                new Producto(1L, "Tablet", 800.0, 5);

        when(productoService.guardarProducto(any(Producto.class)))
                .thenReturn(producto);

        mockMvc.perform(post("/api/productos")

                        .contentType(MediaType.APPLICATION_JSON)

                        .content(objectMapper.writeValueAsString(producto)))

                .andExpect(status().isCreated())

                .andExpect(jsonPath("$.nombre")
                        .value("Tablet"));
    }

    @Test
    void buscarProducto_existente_retorna200()
            throws Exception {

        Producto producto =
                new Producto(1L, "Monitor", 900.0, 3);

        when(productoService.buscarProductoPorId(1L))
                .thenReturn(producto);

        mockMvc.perform(get("/api/productos/1"))

                .andExpect(status().isOk())

                .andExpect(jsonPath("$.nombre")
                        .value("Monitor"));
    }
}