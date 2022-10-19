package com.assignment.xeno.assignment_xeno;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AssignmentXenoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AssignmentXenoApplication.class, args);
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info().title("XenoStack Assignment")
                        .contact(new Contact()
                                .name("Itisha Singh")
                                .email("itisha.singh16@gmail.com"))
                        .version("1.0")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org"))
                        .description("Spring Boot based Backend with PosgtreSQL integrated using JPA"));
    }

}
