package com.gestor.itsm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gestor.itsm.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
