package com.gestor.itsm.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "clientes")

public class Cliente extends Usuario {
    

    public Cliente() {
        super();
    }

    //Constructor
    public Cliente(Long id, String nombre, String email, String telefono) {
        super(id, nombre, email, telefono);
       
    }


    public void setId(Long id) {
        this.id = id;
    }
}
