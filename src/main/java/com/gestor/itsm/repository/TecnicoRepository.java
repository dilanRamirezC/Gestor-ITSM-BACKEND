package com.gestor.itsm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gestor.itsm.model.Tecnico;

public interface TecnicoRepository extends JpaRepository<Tecnico, Long> {
}
