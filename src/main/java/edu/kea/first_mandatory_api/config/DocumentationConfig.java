package edu.kea.first_mandatory_api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Comparator;

@Configuration
@EnableSwagger2
public class DocumentationConfig {
    @Bean
    public Docket swaggerUI(){
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo());
    }

    public ApiInfo apiInfo(){
        return new ApiInfoBuilder().title("Pokemon API").build();
    }

}
