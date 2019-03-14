package training.endava.app.service.impl;

import training.endava.app.domain.Person;
import training.endava.app.repository.PersonRepository;
import training.endava.app.service.PersonService;
import training.endava.app.util.DateUtil;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class PersonServiceImpl implements PersonService {

    public static final int PAGE_SIZE = 3;
    private PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    /**
     * Training-Task:
     * Get the unique surnames in uppercase for the first {@link PersonServiceImpl#PAGE_SIZE} people
     * that are over a specified age
     */
    public List<String> getPeopleSurnamesByAge(int age) {
        return personRepository
                .findAll()
                .stream()
                .filter(person -> getAgeInYears(person) >= age)
                .map(Person::getSurname)
                .map(String::toUpperCase)
                .distinct()
                .limit(PAGE_SIZE)
                .collect(Collectors.toList());
    }

    private int getAgeInYears(Person person) {
        return DateUtil.getDiffYears(person.getBirthday(), getCurrentDate());
    }

    protected Date getCurrentDate() {
        return new Date();
    }

    /**
     * Trainig-Task
     * Get the unique surnames in uppercase for the n-th page
     * ({@link PersonServiceImpl#PAGE_SIZE} people per page) that are over a specified age
     //     */

    public List<String> getPaginatedPeopleByAge(int age, int page) {
        int max = page*PAGE_SIZE;
        int min = (page-1)*PAGE_SIZE;

        if(max > personRepository.findAll().size())
        {
            max = personRepository.findAll().size();
        }

        return personRepository
                .findAll()
                .subList(min, max)
                .stream()
                .filter(person -> getAgeInYears(person) >= age)
                .limit(PAGE_SIZE)
                .map(Person::getSurname)
                .distinct()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }
}
