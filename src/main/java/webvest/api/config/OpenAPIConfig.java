package webvest.api.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;


@Configuration
public class OpenAPIConfig {

	
	 @Value("${webvest.openapi.dev-url}")
	  private String devUrl;

	  @Value("${webvest.openapi.prod-url}")
	  private String prodUrl;

	  @Bean
	  public OpenAPI myOpenAPI() {
	    Server devServer = new Server();
	    devServer.setUrl(devUrl);
	    devServer.setDescription("Server URL em Ambiente de Desenvolvimento");

	    Server prodServer = new Server();
	    prodServer.setUrl(prodUrl);
	    prodServer.setDescription("Server URL em Ambiente de Producao");

	    Contact contact = new Contact();
	    contact.setEmail("igormarinholeo2014@gmail.com");
	    contact.setName("Igor Marinho");
	    contact.setUrl("https://www.linkedin.com/in/igormarinhodev/");

	    License mitLicense = new License().name("MIT License").url("https://choosealicense.com/licenses/mit/");

	    Info info = new Info()
	        .title("API de Investimentos & Conta Corrente")
	        .version("1.0.1")
	        .contact(contact)
	        .description("Produtos Financeiros, Investimentos e Conta-Corrente.").termsOfService("https://www.minhaurl.com/terms")
	        .license(mitLicense);

	    return new OpenAPI()
	    		  .components(new Components()
	                      .addSecuritySchemes("bearer-jwt", new SecurityScheme()
	                              .type(SecurityScheme.Type.HTTP)
	                              .scheme("bearer")
	                              .bearerFormat("JWT")
	                              .name("Authorization")
	                              .in(SecurityScheme.In.HEADER)
	                      )
	              )
	             .addSecurityItem(new SecurityRequirement().addList("bearer-jwt"))
	    		.info(info)
	    		.servers(List.of(devServer, prodServer));
	  }
	
}
