
package com.gestor.itsm.model;

/*
 * Enum que representa los posibles estados de un ticket en el sistema ITSM.
 * Los estados definidos son:
 *      ABIERTO: El ticket ha sido creado y aún no ha sido atendido.
 *      ENPROGRESO: El ticket está siendo atendido por un técnico.
 *      RESUELTO: El ticket ha sido solucionado o cerrado.
 */


public enum EstadoTickete {
    /** Ticket recién creado, pendiente de atención */
    ABIERTO,
    /** Ticket en proceso de resolución por parte del técnico */
    ENPROGRESO,
    /** Ticket solucionado o cerrado */
    RESUELTO;

}
