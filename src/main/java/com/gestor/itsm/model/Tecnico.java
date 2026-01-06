package com.gestor.itsm.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 * Representa un técnico del sistema ITSM.
 * Hereda de la clase Usuario, por lo que posee atributos como id, nombre, email y teléfono.
 * 
 * Esta entidad se mapea a la tabla "tecnicos" en la base de datos.
 * Además, contiene atributos específicos de los técnicos, como su área de soporte y nivel.
 */
@Schema(description = "Entidad que representa un Técnico en el sistema ITSM")
@Entity
@Table(name = "tecnicos")
public class Tecnico extends Usuario {
    
    /*atributos específicos de Técnico */

    /** Área de soporte a la que pertenece el técnico */
    @Schema(description = "Área de soporte del técnico", example = "Redes")
    private String areaSoporte;

    /** Nivel del técnico (por ejemplo, Junior, Senior) */
    @Schema(description = "Nivel del técnico", example = "Senior")
    private String nivel;


   /**
     * Constructor por defecto.
     * Necesario para JPA al instanciar objetos desde la base de datos.
     */
    public Tecnico() {
        super();
    }

    //* Constructor parametrizado para crear un Técnico con todos los atributos. */
    public Tecnico(Long id, String nombre, String email, String telefono, String areaSoporte, String nivel) {
        super(id, nombre, email, telefono);
        this.areaSoporte = areaSoporte;
        this.nivel = nivel;
    }

    /* Obtiene el área de soporte del técnico. */
    public String getAreaSoporte() {
        return areaSoporte;
    }

    /* Obtiene el nivel del técnico. */
    public String getNivel() {
        return nivel;
    }

}
