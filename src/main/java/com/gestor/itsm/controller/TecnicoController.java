package com.gestor.itsm.controller;
import org.springframework.web.bind.annotation.*;
import com.gestor.itsm.service.TecnicoService;
import com.gestor.itsm.model.Tecnico;

@RestController
@RequestMapping("/tecnicos")

public class TecnicoController {

    private final TecnicoService tecnicoService;

    public TecnicoController(TecnicoService tecnicoService) {
        this.tecnicoService = tecnicoService;
    }

    @PostMapping
    public Tecnico CrearTecnico(@RequestBody Tecnico tecnico) {
        
        return tecnicoService.crearTecnico(
            tecnico.getNombre(),
            tecnico.getEmail(),
            tecnico.getTelefono(),
            tecnico.getAreaSoporte(),
            tecnico.getNivel()
        );
    }

}
