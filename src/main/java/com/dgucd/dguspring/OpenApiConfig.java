package com.dgucd.dguspring;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI openAPI() {
        Info info = new Info()
                .title("R&D API Documentation")
                .version("1.0")
                .description("터틀봇을 활용한 동국대학교 중앙도서관 내 금지 물품 식별 시스템");
        return new OpenAPI()
                .components(new Components())
                .info(info);

    }
}
