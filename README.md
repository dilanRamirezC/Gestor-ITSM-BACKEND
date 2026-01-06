#  Sistema de Gestión de Tickets ITSM (V1)

Sistema backend desarrollado en **Java con Spring Boot** para la gestión de tickets de soporte técnico, inspirado en flujos ITSM reales.  
Permite la creación, asignación, seguimiento y cierre de tickets entre **clientes** y **técnicos**.

Este proyecto fue desarrollado como parte de mi crecimiento profesional, enfocándome en **buen diseño, lógica de negocio clara y documentación profesional**.

---

##  Tecnologías utilizadas

- Java 21
- Spring Boot
- Spring Data JPA
- Hibernate
- Maven
- Swagger / OpenAPI 3
- Base de datos relacional (H2 / MySQL)
- Git & GitHub

---

##  Arquitectura del proyecto

El proyecto sigue una **arquitectura en capas**:

- **Controller** → Manejo de peticiones HTTP (API REST)
- **Service** → Lógica de negocio
- **Repository** → Acceso a datos (JPA)
- **Model** → Entidades del dominio
- **Config** → Configuración de Swagger

Este enfoque facilita:
- Mantenimiento
- Escalabilidad
- Separación de responsabilidades

---

##  Modelo de dominio (UML)

El sistema está basado en los siguientes actores principales:

- **Usuario (clase abstracta)**
  - Cliente
  - Técnico
- **Ticket**

 Los diagramas UML se encuentran en la carpeta: Docs


Incluyen:
- Diagrama de clases
- Diagrama de actividades del ciclo de vida del ticket
- Diagrama de casos de uso

---

## Funcionalidades principales

###  Cliente
- Crear tickets de soporte
- Asociarse a tickets existentes

###  Técnico
- Asignarse a tickets
- Cambiar estado del ticket
- Resolver tickets

###  Ticket
- Crear ticket
- Asignar prioridad
- Asignar técnico
- Cambiar estado automáticamente
- Cerrar ticket

---

##  Flujo del ticket

1. El cliente crea un ticket (estado **ABIERTO**)
2. Se asigna prioridad (solo si está ABIERTO)
3. Se asigna un técnico (estado pasa a **EN_PROGRESO**)
4. El técnico resuelve el ticket
5. El ticket se cierra (estado **RESUELTO**)

Este flujo está validado por reglas de negocio en la capa **Service**.

---

##  Documentación de la API (Swagger)

La API está documentada completamente con **Swagger / OpenAPI**.

Una vez levantado el proyecto, se puede acceder a: http://localhost:8080/swagger-ui.html


Swagger documenta:
- Endpoints
- Parámetros
- Modelos
- Estados de respuesta

---

## Estructura del proyecto

src/main/java/com/gestor/itsm
│
├── controller
│ ├── ClienteController
│ ├── TecnicoController
│ └── TicketController
│
├── model
│ ├── Usuario
│ ├── Cliente
│ ├── Tecnico
│ ├── Ticket
│ └── enums
│
├── repository
├── service
└── config


---

##  Decisiones técnicas destacadas

- Uso de **herencia (Usuario → Cliente / Técnico)** para reutilizar atributos comunes
- Reglas de negocio controladas en la capa Service
- Estados del ticket controlados mediante **Enums**
- Documentación automática con Swagger
- Separación clara entre lógica y controladores

---

##  Estado del proyecto

 Versión actual: **V1 – Funcional y estable**

El sistema cumple con todas las funcionalidades principales del ciclo de vida de un ticket.

---

##  Próximas mejoras (V2)

- Autenticación y roles (Spring Security)
- DTOs y validaciones
- Historial de cambios del ticket
- Comentarios en tickets
- Persistencia en MySQL/PostgreSQL
- Pruebas unitarias

---

##  Autor

Proyecto desarrollado por **DilanRamirez**  
Estudiante de la ETIC Enfocado en backend y Ciberseguridad
