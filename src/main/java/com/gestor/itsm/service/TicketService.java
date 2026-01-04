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
import java.util.List;

@Service
public class TicketService {
    // Lógica del servicio para gestionar tickets
  private final TicketRepository ticketRepository;
  private final ClienteRepository clienteRepository;
  private final TecnicoRepository tecnicoRepository;
    
  //Constructor
    public TicketService(TicketRepository ticketRepository, ClienteRepository clienteRepository, TecnicoRepository tecnicoRepository) {
        this.ticketRepository = ticketRepository;
        this.clienteRepository = clienteRepository;
        this.tecnicoRepository = tecnicoRepository;
    }


    //metodo para crear un ticket
    public Ticket crearTicket(String titulo, String descripcion, long clienteId) {
        Cliente cliente = clienteRepository.findById(clienteId)
            .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        Ticket ticket = new Ticket(titulo, descripcion, cliente);
        return ticketRepository.save(ticket);
        }

        //metodo para asignar un tecnico al ticket
    public Ticket asignarTicketATecnico(Long ticketId, long tecnicoId) {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("Ticket no encontrado"));
        Tecnico tecnico = tecnicoRepository.findById(tecnicoId)
                 .orElseThrow(() -> new RuntimeException("Técnico no encontrado"));
        ticket.asignarTecnico(tecnico);
        return ticketRepository.save(ticket);
        }

    //metodo para cambiar el estado del ticket
    public Ticket cambiarEstadoTicket(Long ticketId, EstadoTickete estado) {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("Ticket no encontrado"));

        ticket.cambiarEstado(estado);
        return ticketRepository.save(ticket);
    }

    //metodo para asignar prioridad al ticket
    public Ticket asignarPrioridad(Long ticketId, PrioridadTicket prioridad) {
    Ticket ticket = ticketRepository.findById(ticketId)
        .orElseThrow(() -> new RuntimeException("Ticket no encontrado"));

        if (ticket.getEstado() != EstadoTickete.ABIERTO) {
        throw new RuntimeException("No se puede cambiar la prioridad en este estado");
        }

        ticket.asignarPrioridad(prioridad);
        return ticketRepository.save(ticket);
    }



    //metodo para cerrar el ticket
    public Ticket cerrarTicket(Long ticketId) {
    Ticket ticket = ticketRepository.findById(ticketId)
            .orElseThrow(() -> new RuntimeException("Ticket no encontrado"));

    ticket.cambiarEstado(EstadoTickete.RESUELTO);
    return ticketRepository.save(ticket);
    }
    public List<Ticket> obtenerTodosLosTickets() {
    return ticketRepository.findAll();
    }

    public Ticket obtenerTicketPorId(Long id) {
    return ticketRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Ticket no encontrado"));
    }

}
