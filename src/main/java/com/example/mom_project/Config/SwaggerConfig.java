package com.example.mom_project.Config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("Sales control API")
                .description("Personal project to manage car sales.")
                .version("1.0.0")
                .contact(new Contact()
                    .name("João Pedro Lima")
                    .email("jpbenevideslima0707@gmail.com")
                )
            );
    }
}
