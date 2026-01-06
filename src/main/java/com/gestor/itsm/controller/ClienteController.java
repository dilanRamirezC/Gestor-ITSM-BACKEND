package com.gestor.itsm.controller;
import org.springframework.web.bind.annotation.*;
import com.gestor.itsm.service.ClienteService;
import com.gestor.itsm.model.Cliente;

/**
 * Controlador REST que maneja todas las operaciones relacionadas con los clientes.
 * Proporciona endpoints para crear clientes en el sistema.
 */

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
    @PostMapping
    public Cliente crear(@RequestBody Cliente cliente) {
        return clienteService.crearCliente(cliente);
    }
}
