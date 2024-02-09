package com.demo.appointments.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.tags.Tag;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI myOpenAPI() {
        Server devServer = new Server();
        devServer.setUrl("http://localhost:8080/");
        devServer.setDescription("localhost");

        Contact contact = new Contact();
        contact.setName("Author");
        contact.setEmail("aldungarov.ar@gmail.com");

        License mitLicense = new License().name("Apache 2.0").url("http://springdoc.org");

        List<Tag> tagList = new ArrayList<>();
        tagList.add(new Tag().name("MessageWsController").description("message WebSocket"));

        Info info = new Info()
                .title("Appointments API")
                .version("1.0")
                .contact(contact)
                .description("API creating and managing schedule of appointments.")
                .license(mitLicense);


        return new OpenAPI().info(info).tags(tagList);
    }
}
