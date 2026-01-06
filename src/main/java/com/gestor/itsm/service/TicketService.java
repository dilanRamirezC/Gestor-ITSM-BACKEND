package com.gestor.itsm.service;

import org.springframework.stereotype.Service;

import com.gestor.itsm.repository.ClienteRepository;
import com.gestor.itsm.repository.TecnicoRepository;
import com.gestor.itsm.repository.TicketRepository;
import com.gestor.itsm.model.Cliente;
import com.gestor.itsm.model.Tecnico;
import com.gestor.itsm.model.Ticket;
import com.gestor.itsm.model.EstadoTickete;
import com.gestor.itsm.model.PrioridadTicket;
/* import java.util.List; */


/**
 * Servicio que maneja la lógica de negocio relacionada con los tickets.
 * 
 * Proporciona métodos para crear tickets, asignar técnicos, cambiar estados,
 * asignar prioridad y cerrar tickets. También permite consultar tickets.
 */
@Service
public class TicketService {

    /** Repositorio de tickets para operaciones CRUD */
  private final TicketRepository ticketRepository;

  /** Repositorio de clientes, usado para validar y obtener clientes */
  private final ClienteRepository clienteRepository;

  /** Repositorio de técnicos, usado para validar y obtener técnicos */
  private final TecnicoRepository tecnicoRepository;
    
  /** Constructor que inyecta los repositorios necesarios. */   
    public TicketService(TicketRepository ticketRepository, ClienteRepository clienteRepository, TecnicoRepository tecnicoRepository) {
        this.ticketRepository = ticketRepository;
        this.clienteRepository = clienteRepository;
        this.tecnicoRepository = tecnicoRepository;
    }


     /**
     * Crea un nuevo ticket asociado a un cliente específico.
     * 
     * @param titulo Título del ticket
     * @param descripcion Descripción del problema
     * @param clienteId ID del cliente que crea el ticket
     * @return Ticket guardado en la base de datos
     * @throws RuntimeException si el cliente no existe
     */
    
    public Ticket crearTicket(String titulo, String descripcion, long clienteId) {
        Cliente cliente = clienteRepository.findById(clienteId)
            .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        Ticket ticket = new Ticket(titulo, descripcion, cliente);
        return ticketRepository.save(ticket);
        }

    /**
     * Asigna un técnico a un ticket específico y cambia el estado a ENPROGRESO.
     * 
     * @param ticketId ID del ticket a asignar
     * @param tecnicoId ID del técnico que será asignado
     * @return Ticket actualizado
     * @throws RuntimeException si el ticket o el técnico no existen
     */
        
    public Ticket asignarTicketATecnico(Long ticketId, long tecnicoId) {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("Ticket no encontrado"));
        Tecnico tecnico = tecnicoRepository.findById(tecnicoId)
                 .orElseThrow(() -> new RuntimeException("Técnico no encontrado"));
        ticket.asignarTecnico(tecnico);
        return ticketRepository.save(ticket);
        }

    /**
     * Cambia el estado de un ticket a uno especificado.
     * 
     * @param ticketId ID del ticket
     * @param estado Nuevo estado del ticket
     * @return Ticket actualizado
     * @throws RuntimeException si el ticket no existe
     */    
    public Ticket cambiarEstadoTicket(Long ticketId, EstadoTickete estado) {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("Ticket no encontrado"));

        ticket.cambiarEstado(estado);
        return ticketRepository.save(ticket);
    }

     /**
     * Asigna una prioridad a un ticket solo si el estado es ABIERTO.
     * 
     * @param ticketId ID del ticket
     * @param prioridad Prioridad a asignar
     * @return Ticket actualizado
     * @throws RuntimeException si el ticket no existe o no está en estado ABIERTO
     */
    public Ticket asignarPrioridad(Long ticketId, PrioridadTicket prioridad) {
    Ticket ticket = ticketRepository.findById(ticketId)
        .orElseThrow(() -> new RuntimeException("Ticket no encontrado"));

        if (ticket.getEstado() != EstadoTickete.ABIERTO) {
        throw new RuntimeException("No se puede cambiar la prioridad en este estado");
        }

        ticket.asignarPrioridad(prioridad);
        return ticketRepository.save(ticket);
    }

    /**
     * Cierra un ticket cambiando su estado a RESUELTO.
     * 
     * @param ticketId ID del ticket a cerrar
     * @return Ticket actualizado
     * @throws RuntimeException si el ticket no existe
     */
    public Ticket cerrarTicket(Long ticketId) {
    Ticket ticket = ticketRepository.findById(ticketId)
            .orElseThrow(() -> new RuntimeException("Ticket no encontrado"));

    ticket.cambiarEstado(EstadoTickete.RESUELTO);
    return ticketRepository.save(ticket);
    }


    /* Futura implimentacion de obtencion de tickets 
    public List<Ticket> obtenerTodosLosTickets() {
    return ticketRepository.findAll();
    }
    public Ticket obtenerTicketPorId(Long id) {
    return ticketRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Ticket no encontrado"));
    }
    */
}
