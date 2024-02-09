package com.demo.appointments;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@OpenAPIDefinition(
        info = @Info(
                title = "Appointments API",
                description = "API creating and managing schedule of appointments.", version = "1.0.0",
                contact = @Contact(
                        name = "Author",
                        email = "aldungarov.ar@gmail.com"
                )
        )
)
@SpringBootApplication
@ComponentScan(basePackages = "com.demo.appointments")
@EnableJpaRepositories
public class AppointmentsApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppointmentsApplication.class, args);
    }

}
