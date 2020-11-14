package com.movit;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfiguration {
	
	/*public static final Contact DEFAULT_CONTACT = new Contact("UDEC", "https://www.ucundinamarca.edu.co/",
			"info@unicundi.edu.co");
	public static final ApiInfo DEFAULT_API_INFO = new ApiInfo("Udec documentación", "Documentación", "1.0", "PREMIUM", DEFAULT_CONTACT,
			"Aache 2.0", "https://www.apache.org/licenses/LICENSE-2.0", null);
		
			
    			
	@Bean
	public Docket api() {		
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(DEFAULT_API_INFO);
	}	*/
	
	 @Bean
	    public Docket usersApi() {
	        return new Docket(DocumentationType.SWAGGER_2)
	                .apiInfo(usersApiInfo())
	                .select()//.path PathSelector.any()
	                .apis(RequestHandlerSelectors.any())
	                .build()
	                .useDefaultResponseMessages(false);
	    }

	   private ApiInfo usersApiInfo() {
	        return new ApiInfoBuilder()
	                .title("Service User")
	                .version("1.0")
	                .license("Apache License Version 2.0")
	                .build();
	    }	

}