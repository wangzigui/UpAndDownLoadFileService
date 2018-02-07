package com.nf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2 {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                //.pathMapping("/it/")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.nf.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }
    /*

public Docket createRestApi() { return new Docket(DocumentationType.SWAGGER_2) .genericModelSubstitutes(DeferredResult.class) .useDefaultResponseMessages(false) .forCodeGeneration(false) .pathMapping("/hmd/") .select() .apis(RequestHandlerSelectors.basePackage("com.nffund.controller")) .paths(PathSelectors.any()) .build() .apiInfo(apiInfo()); }

    * */

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("南方通消息中心接口文档.... - RESTful API Docs")
                .description("持续更新...")
                .termsOfServiceUrl("http://localhost:8080/")
                .version("1.0")
                .build();
    }

}
