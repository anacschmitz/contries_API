package com.countries.contries_api.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI countriesCitiesOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Countries & Cities API")
                        .description("Backend service that exposes APIs for managing Countries and Cities, "
                                + "including lookup of cities by country (with pagination) and city details by id.")
                        .version("v1.0.0")
                        .contact(new Contact().name("Countries & Cities API").email("dev@example.com"))
                        .license(new License().name("MIT")));
    }
}
