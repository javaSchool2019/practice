package training.endava.app.service.impl;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import training.endava.app.domain.Person;
import training.endava.app.repository.PersonRepository;
import training.endava.app.service.PersonService;
import training.endava.app.util.DateUtil;

import java.util.ArrayList;
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
        if (age <= 0) {

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

        throw new IllegalArgumentException("Age must be positive");
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
     */
    public List<String> getPaginatedPeopleByAge(int age, int page) {
        if (age <= 0) {
            int maxRange = PAGE_SIZE*page;
            int minRange = (page - 1) * PAGE_SIZE;

            if(maxRange > personRepository.findAll().size()){
                maxRange = personRepository.findAll().size();
            }

            if (personRepository.findAll().size() > page * PAGE_SIZE && page >= 0) {
                return personRepository
                        .findAll()
                        .subList(minRange, maxRange)
                        .stream()
                        .filter(person -> getAgeInYears(person) >= age)
                        .map(Person::getSurname)
                        .map(String::toUpperCase)
                        .distinct()
                        .collect(Collectors.toList());
            }

            throw new IllegalArgumentException("Page not in range");
        }

        throw new IllegalArgumentException("Age must be positive");
    }
}