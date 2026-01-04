package com.gestor.itsm.controller;

import org.springframework.web.bind.annotation.*;
import com.gestor.itsm.service.TicketService;
import com.gestor.itsm.model.EstadoTickete;
import com.gestor.itsm.model.PrioridadTicket;
import com.gestor.itsm.model.Ticket;


@RestController
@RequestMapping("/tickets")
public class TicketController {

    private final TicketService ticketService;
    

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
        
     }

        // Crear ticket
        @PostMapping("/crear")
        public Ticket crearTicket(
            @RequestParam String titulo,
            @RequestParam String descripcion,
            @RequestParam Long clienteId) {                            
            return ticketService.crearTicket(titulo, descripcion, clienteId);
         }

        //Asignar prioridad al ticket
        @PutMapping("/{id}/prioridad")
        public Ticket asignarPrioridad(
            @PathVariable Long id,
            @RequestParam PrioridadTicket prioridad
         ) {
          return ticketService.asignarPrioridad(id, prioridad);
        }

         //Asignar tecnico al ticket
      @PutMapping("/{ticketId}/asignar-tecnico/{tecnicoId}")
         public Ticket asignarTecnico(
            @PathVariable Long ticketId,
            @PathVariable Long tecnicoId) {

         return ticketService.asignarTicketATecnico(ticketId, tecnicoId);
    }

        //Cambiar estado del ticket
        @PutMapping("/{id}/estado")
        public Ticket cambiarEstado(
            @PathVariable Long id,
            @RequestParam EstadoTickete estado
            ) {
         return ticketService.cambiarEstadoTicket(id, estado);
         }
        //Cerrar ticket
         @PutMapping("/{id}/cerrar") 
        public Ticket cerrarTicket(@PathVariable Long id) { 
            return ticketService.cerrarTicket(id);
        }

        //Endpoint de prueba
        @GetMapping
        public String home() {
        return "API de Tickets funcionando";
    }


}

