package com.vijaygenius123.learning.springtodoexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SpringTodoExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringTodoExampleApplication.class, args);
    }

    @Bean
    public Docket swaggerConfiguration(){

        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.ant("/api/v1/*"))
                .apis(RequestHandlerSelectors.basePackage("com.vijaygenius123.learning"))
                .build()
                .apiInfo(apiDetails());
    }

    private ApiInfo apiDetails(){

        return new ApiInfo(
                "Todo Application",
                "Simple Todo App ",
                "1.0.0",
                "Free To Use",
                "Vijayaraghavan",
                "API License",
                "http://vijaygenius123.com"
        );
    }

}
