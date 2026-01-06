package com.gestor.itsm.model;

/**
 * Enum que representa los niveles de prioridad que puede tener un ticket en el sistema ITSM.
 * Esto ayuda a determinar la urgencia con la que un ticket debe ser atendido.
 * Los niveles de prioridad son:
 * 
 *   BAJA: Ticket de baja prioridad, no requiere atención inmediata.
 *   MEDIA: Ticket de prioridad media, debe atenderse en tiempo razonable.
 *   ALTA: Ticket de alta prioridad, requiere atención urgente.
 * 
 */


public enum PrioridadTicket {
    /** Ticket de baja prioridad */
    BAJA,
    /** Ticket de prioridad media */
    MEDIA,
    /** Ticket de alta prioridad */
    ALTA
}
