package com.gestor.itsm.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;


/**
 * Representa un cliente del sistema ITSM.
 * Hereda de la clase Usuario, por lo que posee los atributos básicos
 * como id, nombre, email y teléfono.
 * 
 * Esta entidad se mapea a la tabla "clientes" en la base de datos.
 */


@Entity
@Table(name = "clientes")

public class Cliente extends Usuario {
    
    /**
     * Constructor por defecto.
     * Llama al constructor de la clase padre Usuario.
     * Necesario para JPA al instanciar objetos desde la base de datos.
     */

    public Cliente() {
        super();
    }

    /**
     * Constructor parametrizado para crear un Cliente con todos los atributos.
     *
    */
    public Cliente(Long id, String nombre, String email, String telefono) {
        super(id, nombre, email, telefono);
       
    }

    /**
     * Setter para el ID del cliente.
     * Se puede usar para actualizar el identificador si es necesario.
      */

    public void setId(Long id) {
        this.id = id;
    }
}
