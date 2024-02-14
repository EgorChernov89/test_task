package com.example.demoproject23333.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;


@OpenAPIDefinition(
        info = @Info(
                title = "Тестовое задание",
                description = "Реализовать web¬приложение имитирующее сбор данных с устройств (трекер ADM50) и их преобразование.",
                version = "3.0.0",
                license = @License(name = "Apache 2.0", url = "http://foo.bar"),
                contact = @Contact(
                        name = "Чернов Егор Константинович",
                        email = "chernov.e.k89@gmail.com",
                        url = "www.w.ww"
                )
        ),
        servers = @Server(url = "http://localhost:8096")
)
@SecurityScheme(
        name = "Bearer Authentication",
        description = "токен авторизации",
        paramName = "JWT",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "bearer",
        in = SecuritySchemeIn.HEADER
)
//http://localhost:8096/swagger-ui/index.html#/
public class OpenApiConfig {
}
