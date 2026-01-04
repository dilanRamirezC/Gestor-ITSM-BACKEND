package com.gestor.itsm.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tecnicos")
public class Tecnico extends Usuario {
    
    //atributos específicos de Técnico 
    private String areaSoporte;
    private String nivel;

    //Constructor por defecto
    public Tecnico() {
        super();
    }


    //Constructor
    public Tecnico(Long id, String nombre, String email, String telefono, String areaSoporte, String nivel) {
        super(id, nombre, email, telefono);
        this.areaSoporte = areaSoporte;
        this.nivel = nivel;
    }

    //Getters específicos de Técnico
    public String getAreaSoporte() {
        return areaSoporte;
    }
    public String getNivel() {
        return nivel;
    }

}
