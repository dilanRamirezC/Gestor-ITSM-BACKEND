package com.gestor.itsm.controller;

import org.springframework.web.bind.annotation.*;
import com.gestor.itsm.service.TicketService;
import com.gestor.itsm.model.EstadoTickete;
import com.gestor.itsm.model.PrioridadTicket;
import com.gestor.itsm.model.Ticket;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * Controlador REST que maneja todas las operaciones relacionadas con los tickets.
 * Permite crear tickets, asignar prioridades, asignar técnicos, cambiar estado y cerrarlos.
 */

@Tag (name = "Ticket Controller", description = "Gestión de Tickets ITSM")
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
        //Endpoint para crear un nuevo ticket
        @Operation
        (summary = "Crear un nuevo ticket",
         description = "Crea un ticket con título, descripción y cliente asociado.")

         @ApiResponses ({
            @ApiResponse(responseCode = "200", description = "Ticket creado exitosamente"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos"),
            @ApiResponse(responseCode = "404", description = "Cliente no encontrado")
         })
          
        @PostMapping("/crear")          // Responde a POST /tickets/crear
        public Ticket crearTicket(
            @RequestParam String titulo,
            @RequestParam String descripcion,
            @RequestParam Long clienteId) {                            
            return ticketService.crearTicket(titulo, descripcion, clienteId);
         }



        //Endpoint para asignar prioridad al ticket existente
        @Operation(
            summary = "Asignar prioridad a un ticket",
            description = "permite asignar una prioridad a un ticket solo si está en estado ABIERTO"
        )
        @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Prioridad asignada exitosamente"),
            @ApiResponse(responseCode = "400", description = "No se puede asignar prioridad a un ticket cerrado"),
            @ApiResponse(responseCode = "404", description = "Ticket no encontrado")
        })
        @PutMapping("/{id}/prioridad")  // Responde a PUT /tickets/{id}/prioridad
        public Ticket asignarPrioridad(
            @PathVariable Long id,
            @RequestParam PrioridadTicket prioridad
         ) {
          return ticketService.asignarPrioridad(id, prioridad);
        }

        @Operation(
            summary = "Asignar técnico a un ticket",
            description = "Asigna un técnico a un ticket y cambiar su estado automáticamente.")
        @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Técnico asignado exitosamente"),
            @ApiResponse(responseCode = "404", description = "Ticket o Técnico no encontrado")
         })
         //Endpoint para asignr un técnico a un ticket
      @PutMapping("/{ticketId}/asignar-tecnico/{tecnicoId}") // Responde a PUT /tickets/{ticketId}/asignar-tecnico/{tecnicoId}
         public Ticket asignarTecnico(
            @PathVariable Long ticketId,
            @PathVariable Long tecnicoId) {

         return ticketService.asignarTicketATecnico(ticketId, tecnicoId);
       }


       @Operation(
        summary = "Cambiar estado de un ticket",
        description = "Cambia el estado de un ticket a ABIERTO, ENPROGRESO o RESUELTO.")
        @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Estado cambiado exitosamente"),
            @ApiResponse(responseCode = "400", description = "Estado inválido o cambio no permitido"),
            @ApiResponse(responseCode = "404", description = "Ticket no encontrado")
        })
        //Endpoint para cambiar estado del ticket
        @PutMapping("/{id}/estado")     //Responde a PUT /tickets/{id}/estado
        public Ticket cambiarEstado(
            @PathVariable Long id,
            @RequestParam EstadoTickete estado
            ) {
         return ticketService.cambiarEstadoTicket(id, estado);
         }



   
        //Endpoint para cerrar un ticket
        @Operation(
            summary = "Cerrar un ticket",
            description = "Cierra un ticket cambiando su estado a RESUELTO.")
        @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Ticket cerrado exitosamente"),
            @ApiResponse(responseCode = "404", description = "Ticket no encontrado")
        })
         @PutMapping("/{id}/cerrar")    // Responde a PUT /tickets/{id}/cerrar
        public Ticket cerrarTicket(@PathVariable Long id) { 
            return ticketService.cerrarTicket(id);
        }



        //Endpoint de prueba para verificar que la API de tickets funciona
        @Operation(
            summary = "Endpoint de prueba",
            description = "Verifica que la API de Tickets está funcionando correctamente.")
        @ApiResponses({
            @ApiResponse(responseCode = "200", description = "API de Tickets funcionando")
        })
        @GetMapping     // Responde a GET /tickets
        public String home() {
        return "API de Tickets funcionando";
    }

}

