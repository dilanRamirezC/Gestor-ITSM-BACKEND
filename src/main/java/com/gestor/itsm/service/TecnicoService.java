package com.gestor.itsm.service;
import org.springframework.stereotype.Service;
import com.gestor.itsm.repository.TecnicoRepository;
import com.gestor.itsm.model.Tecnico;


/**
 * Servicio que maneja la lógica de negocio relacionada con los técnicos.
 * 
 * Se encarga de interactuar con el repositorio de técnicos y exponer métodos
 * para crear técnicos. Marcado con @Service para que Spring lo detecte como un bean de servicio.
 */


@Service
public class TecnicoService {

    /** Repositorio de técnicos, usado para operaciones de persistencia en la base de datos */
    private final TecnicoRepository tecnicoRepository;


    /**  Constructor que inyecta el TecnicoRepository. */
    public TecnicoService(TecnicoRepository tecnicoRepository) {
        this.tecnicoRepository = tecnicoRepository;
    }
    
    /* Crea un nuevo técnico en la base de datos. */
    public Tecnico crearTecnico(
        String nombre,
        String email,
        String telefono,
        String areaSoporte,
        String nivel
    ) {
        /* Crear una nueva instancia de Técnico con los datos proporcionados */
    Tecnico tecnico = new Tecnico(
    null, // ID nulo, se generará automáticamente en la base de datos
    nombre,
    email,
    telefono,
    areaSoporte,
    nivel
    );
    
     // Guardar el técnico en la base de datos y retornar el objeto persistido
    return tecnicoRepository.save(tecnico);
    }

    
}
