package com.gestor.itsm.controller;
import org.springframework.web.bind.annotation.*;
import com.gestor.itsm.service.TecnicoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.gestor.itsm.model.Tecnico;

/**
 * Controlador REST que maneja todas las operaciones relacionadas con los técnicos.
 * Proporciona endpoints para crear técnicos en el sistema.
 */

@Tag (name = "Tecnico Controller", description = "Gestión de Técnicos ")
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
    @Operation(summary = "Crear un nuevo técnico", description = "Crea un técnico con nombre, email, teléfono, área de soporte y nivel.")
    @ApiResponses(value = {
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Técnico creado exitosamente") ,
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "Datos inválidos o Incomplentos"),
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500", description = "Error interno del servidor")          
    })
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
