package com.spring.container.spring.configs;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;


@Configuration
public class SetupSwagger {


  @Bean
  public GroupedOpenApi publicApi() {
    return GroupedOpenApi.builder()
      .group("public-api")
      .pathsToMatch("/public/**")
      .build();
  }

  @Bean
  public GroupedOpenApi api() {
    return GroupedOpenApi.builder()
      .group("")
      .packagesToScan("com.spring.container.spring.controllers")
      .build();
  }

  @Bean
  public OpenAPI openAPI() {
    String jwt = "JWT";
    SecurityRequirement securityRequirement = new SecurityRequirement().addList(jwt); // 헤더에 토큰 포함
    Components components = new Components().addSecuritySchemes(jwt, new SecurityScheme()
      .name(jwt)
      .type(SecurityScheme.Type.HTTP)
      .scheme("bearer")
      .bearerFormat("JWT")
      .in(SecurityScheme.In.HEADER)
      .name(HttpHeaders.AUTHORIZATION)
    );
    return new OpenAPI()
      .info(new Info()
      .description("starter pack")
      .title("booster admin swagger"))
      .addSecurityItem(securityRequirement)
      .components(components);
  }
}