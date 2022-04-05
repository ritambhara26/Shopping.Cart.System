package com.example.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
@EnableSwagger2
@CrossOrigin(origins="*")
public class UserserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserserviceApplication.class, args);
	}
	@Configuration
	@EnableSwagger2
	public class SwaggerConfig
	{
	@Bean
	public Docket api() {
	return new Docket(DocumentationType.SWAGGER_2)
	.select()
	.apis(RequestHandlerSelectors.basePackage("com.example.userservice"))
	.build();
	}
	}
	 @Bean
	    public WebMvcConfigurer crosConfigurer() {
	 
	        return new WebMvcConfigurer() {
	            public void addCrosMappings(CorsRegistry registry) {
	                registry.addMapping("pathPattern:'/*'").allowedHeaders("*").allowedOrigins("*").allowedMethods("*")
	                        .allowCredentials(true);
	            }
	 
	        };
	 
	    }
}
