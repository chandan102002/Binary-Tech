package com.example.bankProjetc.SwaggerConfig;

import static springfox.documentation.schema.AlternateTypeRules.newRule;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.async.DeferredResult;

import com.fasterxml.classmate.TypeResolver;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.WildcardType;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig 
{
	private String REST_PACKAGE_PATH = "com.example.bankProjetc";
	
	@Value("${gm.springfox.docket.pathMapping:}")
	private String pathMapping;
	
	@Autowired
	private TypeResolver typeResolver;
	
	@Bean
	public Docket swaggerApiConfig()
	{
		
		
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage(REST_PACKAGE_PATH))
				.paths(PathSelectors.regex("/*.*"))         
                .build().pathMapping(pathMapping)
                .directModelSubstitute(LocalDate.class, String.class)
                .genericModelSubstitutes(ResponseEntity.class)
                .alternateTypeRules(newRule(typeResolver.resolve(DeferredResult.class, typeResolver.resolve(ResponseEntity.class, WildcardType.class)), typeResolver.resolve(WildcardType.class)))
                .useDefaultResponseMessages(false)
                .apiInfo(getApiInfo())
                .securitySchemes(Collections.singletonList(apiKey()))
                .securityContexts(Collections.singletonList(securityContext()));
	}
		
		private ApiInfo getApiInfo() {
	        ApiInfo apiInfo = new ApiInfo(
	                "Spring Boot REST API",
	                "Spring Boot REST API for banking",
	                "1.0",
	                "Terms of service",
	                new Contact("BANKING SYSTEM", "ONLINE-BANK-PROJECT.COM", "CHANDAN.SINGH@BINARYINFORMATICS.COM"),
	               "Apache License Version 2.0",
	                "https://www.apache.org/licenses/LICENSE-2.0",
	                new ArrayList<>());
	        return apiInfo;
		}
	        
	        private ApiKey apiKey() {
	    	    return new ApiKey("mykey", "Authorization", "header");
	    	  }
	        
	        private SecurityContext securityContext() {
	    	    return SecurityContext.builder()
	    	        .securityReferences(defaultAuth())
	    	        .forPaths(PathSelectors.regex("/*.*"))
	    	        .build();
	    	  }
	        List<SecurityReference> defaultAuth() {
	    	    AuthorizationScope authorizationScope
	    	        = new AuthorizationScope("global", "accessEverything");
	    	    AuthorizationScope[] authorizationScopes = {authorizationScope};
	    	    return Collections.singletonList(new SecurityReference("key", authorizationScopes));
	    	  }

}


