package com.roc.SuperMaster.config;

import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author Roc
 * @version 1.0
 * @date 2021/6/9 14:08
 */
@Configuration
@Api(tags = "swagger3的配置类")
public class SwaggerConfig3 {
    @Bean
    public Docket getDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(swaggerDemoApiInfo())
                .select()
                .build();
    }

    private ApiInfo swaggerDemoApiInfo() {
        return new ApiInfoBuilder()
                //添加联系人的联系方式
                .contact(new Contact("西米豆豆", "公司主页", "PM的email"))
                //文档标题
                .title("这里是Swagger的标题")
                //文档描述
                .description("这里是Swagger的描述")
                //文档版本
                .version("1.0.0")
                .build();
    }
}