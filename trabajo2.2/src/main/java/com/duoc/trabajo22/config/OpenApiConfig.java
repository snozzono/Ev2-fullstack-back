package com.duoc.trabajo22.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("MangaStore API")
                        .version("1.0")
                        .description("API REST para gestión de tienda de mangas")
                        .contact(new Contact()
                                .name("MangaStore")
                                .email("admin@mangastore.com")));
    }
}
