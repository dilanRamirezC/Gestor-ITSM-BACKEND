package com.gestor.itsm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gestor.itsm.model.Tecnico;

/**
 * Repositorio para la entidad Tecnico.
 * 
 * Proporciona operaciones CRUD y de consulta sobre la tabla "tecnicos"
 * sin necesidad de implementar métodos manualmente.
 * 
 * Hereda todos los métodos de JpaRepository, tales como:
 * - save(): guardar o actualizar un técnico
 * - findById(): buscar un técnico por su ID
 * - findAll(): obtener todos los técnicos
 * - delete(): eliminar un técnico
 */

public interface TecnicoRepository extends JpaRepository<Tecnico, Long> {
    // No se requieren métodos adicionales por ahora
}
