package com.gestor.itsm.service;
import org.springframework.stereotype.Service;
import com.gestor.itsm.repository.ClienteRepository;
import com.gestor.itsm.model.Cliente;

/**
 * Servicio que maneja la lógica de negocio relacionada con los clientes.
 * 
 * Se encarga de interactuar con el repositorio de clientes y exponer métodos
 * para crear y obtener clientes. Marcado con @Service para que Spring lo detecte
 * como un bean de servicio.
 */

@Service
public class ClienteService {

     /** Repositorio de clientes, usado para operaciones de persistencia en la base de datos */
    private final ClienteRepository clienteRepository;
    
    /**  Constructor que inyecta el ClienteRepository. */
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    /* Crea un nuevo cliente en la base de datos. */
    public Cliente crearCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    /* Obtiene un cliente por su ID. */
    public Cliente obtenerClientePorId(Long id){
        return clienteRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
    }

}
