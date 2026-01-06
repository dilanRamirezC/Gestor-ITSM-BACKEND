package com.gestor.itsm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gestor.itsm.model.Cliente;

/**
 * Repositorio para la entidad Cliente.
 * 
 * Proporciona operaciones CRUD y de consulta sobre la tabla "clientes"
 * sin necesidad de implementar métodos manualmente.
 * 
 * Hereda todos los métodos de JpaRepository, como:
 * - save(): guardar o actualizar un cliente
 * - findById(): buscar un cliente por su ID
 * - findAll(): obtener todos los clientes
 * - delete(): eliminar un cliente
 */

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
     // No se requieren métodos adicionales por ahora
}

