package com.gestor.itsm.controller;
import org.springframework.web.bind.annotation.*;
import com.gestor.itsm.service.ClienteService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.gestor.itsm.model.Cliente;

/**
 * Controlador REST que maneja todas las operaciones relacionadas con los clientes.
 * Proporciona endpoints para crear clientes en el sistema.
 */

@Tag (name = "Cliente Controller", description = "Gestión de Clientes ")
@RestController // Indica que esta clase será un controlador REST y que sus métodos devolverán JSON automáticamente
@RequestMapping("/clientes") // Define la ruta base para todos los endpoints de este controlador
public class ClienteController {

      /** Servicio que contiene la lógica de negocio para clientes */
    private final ClienteService clienteService;

    /**
     * Constructor que inyecta el servicio de clientes.
     * @param clienteService servicio que maneja la lógica de negocio de clientes
     */
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }
    /**
     * Endpoint para crear un cliente.
     * @param cliente Objeto Cliente recibido en el cuerpo de la petición
     * @return El cliente creado y persistido en la base de datos
     */
    @Operation(summary = "Crear un nuevo cliente", description = "Crea un cliente con nombre, email y teléfono.")
    @ApiResponses(value = {
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Cliente creado exitosamente"),
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "Datos inválidos o Incomplentos"),
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500", description = "Error interno del servidor")          
    })

    @PostMapping
    public Cliente crear(@RequestBody Cliente cliente) {
        return clienteService.crearCliente(cliente);
    }
}
