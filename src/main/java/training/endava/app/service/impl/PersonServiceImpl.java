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
    public List<String> getPeopleSurnamesByAge(int age, Date date) {
        if (age < 0 || age > 150) {
            throw new IllegalArgumentException("Age should be between 0 and 150 years");
        }
        return personRepository
                .findAll()
                .stream()
                .filter(person -> getAgeInYears(person, date) >= age)
                .map(Person::getSurname)
                .distinct()
                .limit(PAGE_SIZE)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }

    private int getAgeInYears(Person person, Date date) {
        return DateUtil.getDiffYears(person.getBirthday(), date);
    }

    /**
     * Trainig-Task
     * Get the unique surnames in uppercase for the n-th page
     * ({@link PersonServiceImpl#PAGE_SIZE} people per page) that are over a specified age
     */
    public List<String> getPaginatedPeopleByAge(int age, Date date, int page) {
        if (age < 0 || age > 150) {
            throw new IllegalArgumentException("Age should be between 0 and 150 years.");
        }
        List<Person> people = personRepository.findAll();
        if ((page - 1) * PAGE_SIZE > people.size() || page < 1) {
            throw new UnsupportedOperationException("Page " + page + " does not exist.");
//            return Collections.emptyList();
        }
        int maxIndex = (people.size() < page * PAGE_SIZE) ? people.size() : page * PAGE_SIZE;
        int minIndex = (page - 1) * PAGE_SIZE;
        return personRepository
                .findAll()
                .subList(minIndex, maxIndex)
                .stream()
                .filter(person -> getAgeInYears(person, date) >= age)
                .map(Person::getSurname)
                .map(String::toUpperCase)
                .distinct()
                .limit(PAGE_SIZE)
                .collect(Collectors.toList());
    }
}
