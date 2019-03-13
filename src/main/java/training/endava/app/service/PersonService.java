package training.endava.app.service;

import java.util.Date;
import java.util.List;

public interface PersonService {

    List<String> getPeopleSurnamesByAge(int age, Date date);

    List<String> getPaginatedPeopleByAge(int age, Date date, int page);
}
