package com.gestor.itsm.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tickets")
public class Ticket {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descripcion;

    @Enumerated(EnumType.STRING)
    private EstadoTickete estado;

    @Enumerated(EnumType.STRING)
    private PrioridadTicket prioridad;

    private LocalDateTime fechaCreacion;
   
    //muchos tickets pertenecen a un cliente
    @ManyToOne
    @JoinColumn(name = "cliente_id")

    private Cliente cliente;
   
    //muchos tickets pueden ser asignados a un técnico
    @ManyToOne
    @JoinColumn(name = "tecnico_id")
    private Tecnico tecnico;

    //constructor vacio
    public Ticket() {
        
    }

    
    public Ticket(String titulo, String descripcion, Cliente cliente) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.estado = EstadoTickete.ABIERTO; //Estado inicial
        this.prioridad = PrioridadTicket.BAJA; //Prioridad por defecto
        this.fechaCreacion = LocalDateTime.now();
        this.cliente = cliente;
    }

    //Getters y metodos de dominio

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
