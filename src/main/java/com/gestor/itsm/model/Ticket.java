package com.gestor.itsm.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;


/**
 * Representa un ticket en el sistema ITSM.
 * Un ticket contiene información sobre el problema reportado por un cliente,
 * su estado, prioridad, fecha de creación y el técnico asignado.
 * 
 * Esta entidad se mapea a la tabla "tickets" en la base de datos.
 */


@Schema(description = "Entidad que representa un Ticket en el sistema ITSM")
@Entity
@Table(name = "tickets")
public class Ticket {
 
    /** Identificador único del ticket, autogenerado */  
 @Schema(description = "Identificador único del ticket", example = "1")
 @Id 
 @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
     /** Título breve del ticket */
    @Schema(description = "Título breve del ticket", example = "Falla en el acceso al correo") 
    private String titulo;
  
    /** Descripción detallada del problema reportado */
    @Schema(description = "Descripción detallada del problema reportado", example = "No puedo acceder a mi correo electrónico desde ayer.")
    private String descripcion;

    /** Estado actual del ticket */
    @Schema(description = "Estado actual del ticket", example = "ABIERTO")
    @Enumerated(EnumType.STRING)
    private EstadoTickete estado;

    /** Prioridad asignada al ticket */
    @Schema(description = "Prioridad asignada al ticket", example = "ALTA")
    @Enumerated(EnumType.STRING)
    private PrioridadTicket prioridad;

    /** Fecha y hora de creación del ticket */
    private LocalDateTime fechaCreacion;
   
    /** Relación muchos-a-uno con Cliente: muchos tickets pueden pertenecer a un cliente */
    @Schema(description = "Cliente que reportó el ticket")
    @ManyToOne
    @JoinColumn(name = "cliente_id")

    private Cliente cliente;
   
    /** Relación muchos-a-uno con Tecnico: muchos tickets pueden ser asignados a un técnico */
    @Schema(description = "Técnico asignado al ticket")
    @ManyToOne
    @JoinColumn(name = "tecnico_id")
    private Tecnico tecnico;
   
    /**
     * Constructor por defecto.
     * Necesario para JPA al instanciar objetos desde la base de datos.
     */
    public Ticket() {
        
    }


    /* Constructor parametrizado para crear un Ticket con los atributos esenciales. */
    public Ticket(String titulo, String descripcion, Cliente cliente) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.estado = EstadoTickete.ABIERTO; //Estado inicial
        this.prioridad = PrioridadTicket.BAJA; //Prioridad por defecto
        this.fechaCreacion = LocalDateTime.now();
        this.cliente = cliente;
    }

    //Getters de dominio

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public EstadoTickete getEstado() {
        return estado;
    }

    public PrioridadTicket getPrioridad() {
        return prioridad;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    /* Métodos de negocio para cambiar el estado, prioridad y asignar técnico */
    public void cambiarEstado(EstadoTickete estado) {
        this.estado = estado;
    }

    public void asignarPrioridad(PrioridadTicket prioridad) {
        this.prioridad = prioridad;
    }

    public void asignarTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
        this.estado = EstadoTickete.ENPROGRESO;
    }



}
