package training.endava.app;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import training.endava.app.repository.Database;
import training.endava.app.repository.PersonRepository;

import javax.persistence.EntityManager;
import javax.swing.text.html.parser.Entity;
import java.sql.Connection;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

/*		PersonRepository pR = new PersonRepository();
		try {
			Connection conn = Database.getInstance().connect();
			System.out.println("-----All persons from tabel Person-----");
			pR.getPerson();
			System.out.println("-----Country from tabel Address-------");
			pR.getAddress();
			System.out.println("-----Provider from tabel PhoneNumber---");
			pR.getPhoneNumber();

			System.out.println("------Insert into Person new row-------");
			//pR.insertPerson("Bucuresti",1991-12-02,"Anastasia",4);

			System.out.println("------Before ninety-------------");
			pR.getPersonsBeforeNinety();

			System.out.println("------Same city were born-------");
			pR.sameCityTheyWereBorn();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
*/
	}

}
