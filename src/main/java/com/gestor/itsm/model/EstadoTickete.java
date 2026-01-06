
package com.gestor.itsm.model;

import io.swagger.v3.oas.annotations.media.Schema;

/*
 * Enum que representa los posibles estados de un ticket en el sistema ITSM.
 * Los estados definidos son:
 *      ABIERTO: El ticket ha sido creado y aún no ha sido atendido.
 *      ENPROGRESO: El ticket está siendo atendido por un técnico.
 *      RESUELTO: El ticket ha sido solucionado o cerrado.
 */

@Schema(description = "Enum que representa los posibles estados de un Ticket en el sistema ITSM")
public enum EstadoTickete {
    /** Ticket recién creado, pendiente de atención */
    ABIERTO,
    /** Ticket en proceso de resolución por parte del técnico */
    ENPROGRESO,
    /** Ticket solucionado o cerrado */
    RESUELTO;

}
