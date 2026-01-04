package com.gestor.itsm.service;
import org.springframework.stereotype.Service;
import com.gestor.itsm.repository.TecnicoRepository;
import com.gestor.itsm.model.Tecnico;
@Service
public class TecnicoService {

    private final TecnicoRepository tecnicoRepository;

    public TecnicoService(TecnicoRepository tecnicoRepository) {
        this.tecnicoRepository = tecnicoRepository;
    }
    public Tecnico crearTecnico(
        String nombre,
        String email,
        String telefono,
        String areaSoporte,
        String nivel
    ) {
    Tecnico tecnico = new Tecnico(
    null,
    nombre,
    email,
    telefono,
    areaSoporte,
    nivel
    );

    return tecnicoRepository.save(tecnico);
    }

    
}
