package com.baobei.attendance.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author tcg
 * @date 2021/4/14
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket webApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .pathMapping("/")
                .groupName("Web Api")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.baobei.attendance.web.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(buildApiInfo("雪宝贝的考勤系统 Web Api", ""));
    }

    @Bean
    public Docket weChatApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .pathMapping("/")
                .groupName("WeChat Api")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.baobei.attendance.wechat.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(buildApiInfo("雪宝贝的考勤系统 WeChat Api", ""));
    }

    private ApiInfo buildApiInfo(String title, String description) {
        return new ApiInfoBuilder()
                .title(title)
                .description(description)
                .version("1.0")
                .build();
    }

}
