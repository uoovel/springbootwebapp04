//https://www.codejava.net/frameworks/spring-boot/how-to-create-a-spring-boot-web-application-spring-mvc-with-jsp-thymeleaf
//https://ozk.codejava.net/java-se/jdbc/connect-to-h2-database-examples
//https://ozk.codejava.net/frameworks/spring-boot/spring-boot-crud-example-with-spring-mvc-spring-data-jpa-thymeleaf-hibernate-mysql
package net.codeurmas.SpringBootWebApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootWebAppApplication {

	public static void main(String[] args) throws SQLException {
		SpringApplication.run(SpringBootWebAppApplication.class, args);
		
		//create db
		String jdbcURL = "jdbc:h2:~/test";
        String username = "sa";
        String password = "1234";
        
        Connection connection = DriverManager.getConnection(jdbcURL, username, password);
 
        System.out.println("Connected to H2 embedded database.");
        Statement statement = connection.createStatement();
        
        String sql = "DROP TABLE IF EXISTS students CASCADE";        
        statement.execute(sql);        
        sql = "DROP TABLE IF EXISTS product CASCADE";        
        statement.execute(sql);
        
        sql = "Create table students (ID int primary key, name varchar(50))";   
                 
        statement.execute(sql);
         
        System.out.println("Created table students.");
         
        sql = "Insert into students (ID, name) values (1, 'Nam Ha Minh')";
         
        int rows = statement.executeUpdate(sql);
         
        if (rows > 0) {
            System.out.println("Inserted a new row.");
        }
        
        sql = "Create table product ("
        		+ "ID int NOT NULL AUTO_INCREMENT, "
        		+ "name varchar(50), PRIMARY KEY(ID))"; 
        statement.execute(sql);
        System.out.println("Created table product.");
        /*
        sql = "Insert into product (ID, name) values (1, 'Rocker')";
        
        rows = statement.executeUpdate(sql);
         
        if (rows > 0) {
            System.out.println("Inserted a new row into product.");
        }*/
 
        connection.close();
		
	}

}
