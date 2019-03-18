package training.endava.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import training.endava.app.domain.Person;
import training.endava.app.domain.PhoneNumber;
import training.endava.app.repository.DatabaseConnection;
import training.endava.app.repository.PersonRepository;

import java.sql.*;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class DemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);
		/*
		PersonRepository pRep=new PersonRepository();
		System.out.println("All persons");
		System.out.println(pRep.getAllPersonsFromDbByAge());
		System.out.println("AF BY COUNTRY");
		System.out.println(pRep.getAllPersonsFromDbByCountry());
		System.out.println("AF BY City");
		System.out.println(pRep.getAllPersonsFromSameCountryCityStreet("Iasi"));

		//System.out.println("Insert PhoneNumber");

		//	PhoneNumber ph=new PhoneNumber(6,"5555555","orangeInsert",2);
		//pRep.insertPhoneNumber(ph);
		System.out.println("Update pers by id");
		pRep.updatePhoneNrByPersId(1,"33333","orangeChange");

		System.out.println("ALL persons with same provider");
		System.out.println(pRep.getAllPersonWithSamePhoneProvider("orangeChange"));

*/



	}


}