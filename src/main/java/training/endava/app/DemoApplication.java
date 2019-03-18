package training.endava.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import training.endava.app.controller.PersonController;
import training.endava.app.domain.PhoneNumber;
import training.endava.app.repository.PersonDbRepository;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	//	PersonDbRepository personDbRepository = new PersonDbRepository();
		//System.out.println(personDbRepository.getAllPersonsBornBefore1990().size());
//		System.out.println(personDbRepository.getAllPersonsThatLiveOnTheSameCity("Iasi").size());
//		System.out.println(personDbRepository.getAllPersonsThatLiveOnTheSameTown("Vorona").size());
//		System.out.println(personDbRepository.getAllPersonsThatHaveTheSamePhoneProvider("Telekom").size());
//		System.out.println(personDbRepository.insertPhoneNumber(new PhoneNumber(303,"07568469499","Orange", 3)));
		//System.out.println(personDbRepository.updateAdressByPersonId(3,"Strada Endava","Vaslui","Iasi"));
	}

}
