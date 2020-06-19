package com.bns;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.bns.utility.DateUtility;
import com.google.common.collect.Lists;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.ApiKeyVehicle;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
//public class SpringBootJwtApplication extends SpringBootServletInitializer{
public class SpringBootJwtApplication {

	private static final Logger LOGGER = LogManager.getLogger(SpringBootJwtApplication.class);

	/*
	 * @Override protected SpringApplicationBuilder
	 * configure(SpringApplicationBuilder springApplicationBuilder) { return
	 * springApplicationBuilder.sources(SpringBootJwtApplication.class); }
	 */
	
	public static void main(String[] args) {
		LOGGER.info("test");
		SpringApplication.run(SpringBootJwtApplication.class, args);
	}

	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/DPS/V1/**"))
				.apis(RequestHandlerSelectors.basePackage("com.bns"))
				.build()
				.apiInfo(apiDetails());
	}
	
	
	
	private ApiInfo apiDetails() {
		return new ApiInfo(
				"Demand Planning Service",
				"Docuentation of Demand Planning Rest service", 
				"1.0",
				"Free to use", 
				new springfox.documentation.service.Contact(
						"Luxsh Technologies LTD.",
						"http://luxshtech.com/", 
						"mehul.makwana@bnscolorama.co.uk"),
				"API Liceance", 
				"http://luxshtech.com/index.html", 
				java.util.Collections.EMPTY_LIST
				);
	}
	
	
	private ApiKey apiKey() {
		return new ApiKey("AUTHORIZATION", "api_key", "header");
	}
	
	 @Bean
	 SecurityConfiguration security() {
	 return new SecurityConfiguration(
	 null,
	 null,
	 null, // realm Needed for authenticate button to work
	 null, // appName Needed for authenticate button to work
	 "Bearer ",// apiKeyValue
	 ApiKeyVehicle.HEADER,
	 "AUTHORIZATION", //apiKeyName
	 null);
	 }
	 
	 private SecurityContext securityContext() {
		    return SecurityContext.builder()
		        .securityReferences(defaultAuth())
		        .forPaths(PathSelectors.regex("/DPS/V1/**"))
		        .build();
		  }
	 
	 List<SecurityReference> defaultAuth() {
		    AuthorizationScope authorizationScope
		        = new AuthorizationScope("global", "accessEverything");
		    AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
		    authorizationScopes[0] = authorizationScope;
		    return Lists.newArrayList(
		        new SecurityReference("AUTHORIZATION", authorizationScopes));
		  }
}
