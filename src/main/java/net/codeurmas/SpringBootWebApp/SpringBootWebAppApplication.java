//https://www.codejava.net/frameworks/spring-boot/how-to-create-a-spring-boot-web-application-spring-mvc-with-jsp-thymeleaf
//https://ozk.codejava.net/java-se/jdbc/connect-to-h2-database-examples
//https://ozk.codejava.net/frameworks/spring-boot/spring-boot-crud-example-with-spring-mvc-spring-data-jpa-thymeleaf-hibernate-mysql
//docs.liquibase.com/tools-integrations/spring-boot/using-springboot-with-maven.html
//baeldung.com/spring-boot-testing
//baeldung.com/spring-boot-bean-validation
//baeldung.com/spring-thymeleaf-error-messages
//baeldung.com/spring-thymeleaf-css-js
package net.codeurmas.SpringBootWebApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootWebAppApplication {

	public static void main(String[] args){
		
		SpringApplication.run(SpringBootWebAppApplication.class, args);		
	
		System.out.println("N2 embedded DB created, WebApp is running");
		
	}

}
