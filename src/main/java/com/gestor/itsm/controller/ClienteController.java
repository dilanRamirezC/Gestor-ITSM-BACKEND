package com.gestor.itsm.controller;
import org.springframework.web.bind.annotation.*;
import com.gestor.itsm.service.ClienteService;
import com.gestor.itsm.model.Cliente;



@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public Cliente crear(@RequestBody Cliente cliente) {
        return clienteService.crearCliente(cliente);
    }
}
