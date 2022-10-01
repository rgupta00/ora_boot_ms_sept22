package com.productapp.config;

import org.springframework.stereotype.Component;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
@Component
@OpenAPIDefinition(info = @Info(title = "productapp API", version = "2.5", description = "Oracle API"))
public class SwaggerConfig {

}
