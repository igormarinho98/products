package webvest.api.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;


public class OpenAPIConfig {

	
	 @Value("${webvest.openapi.dev-url}")
	  private String devUrl;

	  @Value("${webvest.openapi.prod-url}")
	  private String prodUrl;

	  @Bean
	  public OpenAPI myOpenAPI() {
	    Server devServer = new Server();
	    devServer.setUrl(devUrl);
	    devServer.setDescription("Server URL in Development environment");

	    Server prodServer = new Server();
	    prodServer.setUrl(prodUrl);
	    prodServer.setDescription("Server URL in Production environment");

	    Contact contact = new Contact();
	    contact.setEmail("igormarinholeo2014@gmail.com");
	    contact.setName("Igor Marinho");
	    contact.setUrl("https://linkedin/igormarinhodev");

	    License mitLicense = new License().name("MIT License").url("https://choosealicense.com/licenses/mit/");

	    Info info = new Info()
	        .title("Banking Products Management API")
	        .version("1.0")
	        .contact(contact)
	        .description("This API exposes endpoints to manage tutorials.").termsOfService("https://www.bezkoder.com/terms")
	        .license(mitLicense);

	    return new OpenAPI().info(info).servers(List.of(devServer, prodServer));
	  }
	
}
