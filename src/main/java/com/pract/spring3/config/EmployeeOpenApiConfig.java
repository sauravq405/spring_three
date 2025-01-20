package com.pract.spring3.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(title = "Employee API", version = "v1", description = "API for managing Employee records"))
public class EmployeeOpenApiConfig {
}
