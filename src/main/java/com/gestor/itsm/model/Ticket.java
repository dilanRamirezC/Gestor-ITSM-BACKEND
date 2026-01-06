package com.gestor.itsm.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;


/**
 * Representa un ticket en el sistema ITSM.
 * Un ticket contiene información sobre el problema reportado por un cliente,
 * su estado, prioridad, fecha de creación y el técnico asignado.
 * 
 * Esta entidad se mapea a la tabla "tickets" en la base de datos.
 */



@Entity
@Table(name = "tickets")
public class Ticket {
 
    /** Identificador único del ticket, autogenerado */  
 @Id 
 @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

     /** Título breve del ticket */
    private String titulo;

    /** Descripción detallada del problema reportado */
    private String descripcion;

    /** Estado actual del ticket */
    @Enumerated(EnumType.STRING)
    private EstadoTickete estado;

    /** Prioridad asignada al ticket */
    @Enumerated(EnumType.STRING)
    private PrioridadTicket prioridad;

    /** Fecha y hora de creación del ticket */
    private LocalDateTime fechaCreacion;
   
    /** Relación muchos-a-uno con Cliente: muchos tickets pueden pertenecer a un cliente */
    @ManyToOne
    @JoinColumn(name = "cliente_id")

    private Cliente cliente;
   
    /** Relación muchos-a-uno con Tecnico: muchos tickets pueden ser asignados a un técnico */
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
