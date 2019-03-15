package training.endava.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import training.endava.app.domain.Person;
import training.endava.app.repository.DatabaseConnection;
import training.endava.app.repository.PersonRepository;

import java.sql.*;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class DemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);
		PersonRepository pRep=new PersonRepository();
		System.out.println("AF BY COUNTRY");
		System.out.println(pRep.getAllPersonsFromDbByCountry());
		System.out.println("AF BY City");
		System.out.println(pRep.getAllPersonsFromSameCountryCityStreet("Iasi"));





	}


}