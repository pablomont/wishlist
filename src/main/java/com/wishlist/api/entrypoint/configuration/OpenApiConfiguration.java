package com.wishlist.api.entrypoint.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI().info(new Info()
            .title("Wishlist - REST API")
            .description("""
                API REST do serviço de \
                Lista de desejos
                """)
            .version("1.0.0")
            .license(new License()
                .name("Wishlist")
                .url("https://wishlist-challenge.com")));
    }
}
