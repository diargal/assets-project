package com.analista.desarrollo.infrastructure.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de gestión de activos")
                        .version("0.11")
                        .description("API para gestionar los datos de los activos y calcular la depreciación de los mismos")
                        .contact(new Contact()
                                .name("Diego García")
                                .email("digarciaalt@gmail.com"))
                );
    }
}
