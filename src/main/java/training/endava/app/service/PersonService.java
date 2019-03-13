package training.endava.app.service;

import java.util.List;

public interface PersonService {

    List<String> getPeopleSurnamesByAge(int age);

    List<String> getPaginatedPeopleByAge(int age, int page);
}
