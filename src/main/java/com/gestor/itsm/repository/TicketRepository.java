package com.gestor.itsm.repository;

import com.gestor.itsm.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Repositorio para la entidad Ticket.
 * 
 * Proporciona operaciones CRUD y de consulta sobre la tabla "tickets"
 * sin necesidad de implementar métodos manualmente.
 * 
 * Hereda todos los métodos de JpaRepository, tales como:
 * - save(): guardar o actualizar un ticket
 * - findById(): buscar un ticket por su ID
 * - findAll(): obtener todos los tickets
 * - delete(): eliminar un ticket
 */
@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    // No se requieren métodos adicionales por ahora
}