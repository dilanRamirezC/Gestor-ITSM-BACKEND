package com.gestor.itsm.controller;

import org.springframework.web.bind.annotation.*;
import com.gestor.itsm.service.TicketService;
import com.gestor.itsm.model.EstadoTickete;
import com.gestor.itsm.model.PrioridadTicket;
import com.gestor.itsm.model.Ticket;


/**
 * Controlador REST que maneja todas las operaciones relacionadas con los tickets.
 * Permite crear tickets, asignar prioridades, asignar técnicos, cambiar estado y cerrarlos.
 */


@RestController // Indica que esta clase es un controlador REST y los métodos devuelven JSON
@RequestMapping("/tickets") // Ruta base para todos los endpoints de tickets
public class TicketController {

    /** Servicio que contiene la lógica de negocio para tickets */
    private final TicketService ticketService;
    
    /**
     * Constructor que inyecta el servicio de tickets
     * @param ticketService servicio que maneja la lógica de los tickets
     */

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
        
     }

        //Endpoint para crear un ticket
        @PostMapping("/crear")          // Responde a POST /tickets/crear
        public Ticket crearTicket(
            @RequestParam String titulo,
            @RequestParam String descripcion,
            @RequestParam Long clienteId) {                            
            return ticketService.crearTicket(titulo, descripcion, clienteId);
         }

        //Endpoint para asignar prioridad al ticket existente
        @PutMapping("/{id}/prioridad")  // Responde a PUT /tickets/{id}/prioridad
        public Ticket asignarPrioridad(
            @PathVariable Long id,
            @RequestParam PrioridadTicket prioridad
         ) {
          return ticketService.asignarPrioridad(id, prioridad);
        }

         //Endpoint para asignr un técnico a un ticket
      @PutMapping("/{ticketId}/asignar-tecnico/{tecnicoId}") // Responde a PUT /tickets/{ticketId}/asignar-tecnico/{tecnicoId}
         public Ticket asignarTecnico(
            @PathVariable Long ticketId,
            @PathVariable Long tecnicoId) {

         return ticketService.asignarTicketATecnico(ticketId, tecnicoId);
    }

        //Endpoint para ambiar estado del ticket
        @PutMapping("/{id}/estado")     //Responde a PUT /tickets/{id}/estado
        public Ticket cambiarEstado(
            @PathVariable Long id,
            @RequestParam EstadoTickete estado
            ) {
         return ticketService.cambiarEstadoTicket(id, estado);
         }

        //Endpoint para cerrar un ticket
         @PutMapping("/{id}/cerrar")    // Responde a PUT /tickets/{id}/cerrar
        public Ticket cerrarTicket(@PathVariable Long id) { 
            return ticketService.cerrarTicket(id);
        }

        //Endpoint de prueba para verificar que la API de tickets funciona
        @GetMapping     // Responde a GET /tickets
        public String home() {
        return "API de Tickets funcionando";
    }


}

