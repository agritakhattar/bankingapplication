package com.cbdg.interview.application;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Banking API",
				version = "1.0",
				description = """
            Banking REST API for managing accounts and transactions.
            
            Features:
            * Account Management
            * Transaction Processing
            * Balance Inquiries
            * Transaction History
            
            Database: H2 in-memory database (available at /h2-console)
            Authentication: Basic Auth with username 'user'
            """,
				contact = @Contact(
						name = "Banking API Support",
						email = "support@bankingapi.com"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://www.apache.org/licenses/LICENSE-2.0"
				)
		),
		servers = {
				@Server(url = "http://localhost:8080", description = "Local Development")
		}
)
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}