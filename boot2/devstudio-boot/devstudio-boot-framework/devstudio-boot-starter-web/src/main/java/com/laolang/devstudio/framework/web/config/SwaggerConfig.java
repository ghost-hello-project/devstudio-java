package com.laolang.devstudio.framework.web.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public GroupedOpenApi systemApi() {
        String[] paths = {"/**"};
        String[] packagedToMatch = {"com.laolang.devstudio.module.system.controller"};
        return GroupedOpenApi.builder().group("system")
                .pathsToMatch(paths)
                .packagesToScan(packagedToMatch).build();
    }

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("thresh")
                        .version("0.1")
                        .description("小东子, 给我狠狠地淦留学生 (*￣︶￣)")
                        .termsOfService("https://gitee.com/bzrj")
                        .license(new License().name("MIT").url("https://gitee.com/bzrj"))
                );
    }
}
