package com.gestor.itsm.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Configuración de Swagger/OpenAPI para la documentación de la API REST
@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Gestor ITSM API")
                        .version("v1.0")
                        .description("""
                        API REST para la gestión de tickets ITSM.
                        Permite crear tickets, asignar técnicos,
                        cambiar estados y prioridades.
                        """)
                        .contact(new Contact()
                                .name("Dilan Ramirez")
                                .email("tu_email@ejemplo.com")
                        )
                );
    }
}
