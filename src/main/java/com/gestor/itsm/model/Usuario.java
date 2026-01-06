package com.gestor.itsm.model;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;


/**
 * Clase base abstracta que representa un usuario del sistema ITSM.
 * 
 * Esta clase define atributos y comportamientos comunes para todos los tipos de usuarios,
 * como Cliente y Tecnico. Al usar @MappedSuperclass, JPA no creará una tabla específica
 * para Usuario, pero sus atributos serán heredados por las entidades hijas.
 */

@Schema(description = "Entidad base que representa un Usuario en el sistema ITSM")  
@MappedSuperclass
public abstract class Usuario {
    

    //Atributos comunes

    /** Identificador único del usuario, autogenerado */
    @Schema(description = "Identificador único del usuario", example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    /** Nombre completo del usuario */
    @Schema(description = "Nombre completo del usuario", example = "Juan Pérez")
    protected String nombre;

    /** Correo electrónico del usuario */
    @Schema(description = "Correo electrónico del usuario", example = "example@gmail.com")
    protected String email;

    /** Número de teléfono del usuario */
    @Schema(description = "Número de teléfono del usuario", example = "+123456789")
    protected String telefono;

    /**
     * Constructor por defecto.
     * Necesario para JPA al instanciar objetos desde la base de datos.
     */

    protected Usuario() {
        
    }


    /* Constructor parametrizado para crear un Usuario con todos los atributos. */
    public Usuario(Long id, String nombre, String email, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
    }

    //Getters generales
    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    //Setters generales

    /* Actualizar el nombre del usuario */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /* Actualizar el correo electrónico del usuario */
    public void setEmail(String email) {
        this.email = email;
    }
    /* Actualizar el número de teléfono del usuario */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    /* Actualizar el ID del usuario */
    public void setId(Long id) {
        this.id = id;
    }
    
}
