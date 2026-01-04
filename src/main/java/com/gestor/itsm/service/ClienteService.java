package com.gestor.itsm.service;
import org.springframework.stereotype.Service;
import com.gestor.itsm.repository.ClienteRepository;
import com.gestor.itsm.model.Cliente;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;
    

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente crearCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public Cliente obtenerClientePorId(Long id){
        return clienteRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
    }

}
