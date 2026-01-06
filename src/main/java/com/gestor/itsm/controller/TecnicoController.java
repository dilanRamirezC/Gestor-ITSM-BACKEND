package com.gestor.itsm.controller;
import org.springframework.web.bind.annotation.*;
import com.gestor.itsm.service.TecnicoService;
import com.gestor.itsm.model.Tecnico;

/**
 * Controlador REST que maneja todas las operaciones relacionadas con los técnicos.
 * Proporciona endpoints para crear técnicos en el sistema.
 */
@RestController // Indica que esta clase será un controlador REST y que sus métodos devolverán JSON automáticamente
@RequestMapping("/tecnicos") // Define la ruta base para todos los endpoints de este controlador

public class TecnicoController {

    /** Servicio que contiene la lógica de negocio para técnicos */
    private final TecnicoService tecnicoService;

     /**
     * Constructor que inyecta el servicio de técnicos.
     * @param tecnicoService servicio que maneja la lógica de negocio de técnicos
     */
    public TecnicoController(TecnicoService tecnicoService) {
        this.tecnicoService = tecnicoService;
    }

    /**
     * Endpoint para crear un técnico.
     * @param tecnico Objeto Tecnico recibido en el cuerpo de la petición
     * @return El técnico creado y persistido en la base de datos
     */
    @PostMapping
    public Tecnico CrearTecnico(@RequestBody Tecnico tecnico) {
        
        return tecnicoService.crearTecnico(
            tecnico.getNombre(),    // Nombre del técnico
            tecnico.getEmail(),    // Email del técnico
            tecnico.getTelefono(),  // Teléfono del técnico
            tecnico.getAreaSoporte(), // Área de soporte del técnico
            tecnico.getNivel()  // Nivel del técnico
        );
    }

}
