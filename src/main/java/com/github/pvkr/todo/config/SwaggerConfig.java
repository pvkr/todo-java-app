package com.github.pvkr.todo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.BasicAuth;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/swagger-ui/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/springfox-swagger-ui/")
                .resourceChain(false);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry
                .addRedirectViewController("/", "/swagger-ui/index.html");
    }

    @Bean
    public Docket todoApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("@todo-service-api")
                .apiInfo(apiInfo())
                .select()
                .paths(regex("/api/v1/.*"))
                .build()
                .securitySchemes(basicAuthScheme());
    }

    @Bean
    public Docket managementApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("~management-api")
                .apiInfo(apiInfo())
                .select()
                .paths(regex("/health").or(regex("/info")))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Todo Application")
                .description("Application created for educational purpose")
                .contact(new Contact("pvkr", "", ""))
                .license("MIT License")
                .licenseUrl("https://github.com/pvkr/todo-java-app/blob/main/LICENSE")
                .version("2.0")
                .build();
    }

    private List<SecurityScheme> basicAuthScheme() {
        return List.of(new BasicAuth("basicAuth"));
    }
}
