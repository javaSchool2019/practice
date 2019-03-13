package training.endava.app.service.impl;

import org.junit.Test;
import org.springframework.web.bind.annotation.PutMapping;
import training.endava.app.domain.Person;
import training.endava.app.repository.PersonRepository;
import training.endava.app.repository.StubPersonRepository;
import training.endava.app.service.PersonService;
import training.endava.app.test.helpers.DateBuilder;
import training.endava.app.test.helpers.PersonTestHelper;
import training.endava.app.util.DateUtil;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Write some more tests using the {@link StubPersonRepository}
 * <p/>
 * Try to identify where you can use Mockito for simpler test doubles
 * <p/>
 */
public class PersonServiceImplTest {

    @Test
    public void shouldReturnSamePeopleForUniquePersons() throws Exception {
        PersonService personService = getPersonService("unique-contacts-input.json");
        List<String> expectedPersonList = Arrays.asList("MARINESCU", "POPESCU", "IONESCU");

        List<String> actualPersonList = personService.getPeopleSurnamesByAge(50);

        assertThat("Expected to contain same people",
                actualPersonList, containsInAnyOrder(expectedPersonList.toArray()));
    }

    @Test
    public void shouldReturnUniqueNamesWhenPeopleHaveSameSurname() throws Exception {
        PersonService personService = getPersonService("duplicated-surnames-contacts-input.json");
        List<String> expectedPersonList = Arrays.asList("POPESCU", "Z-ULESCU", "X-ULESCU");

        List<String> actualPersonList = personService.getPeopleSurnamesByAge(50);

        assertThat("Expected to contain same people",
                actualPersonList, containsInAnyOrder(expectedPersonList.toArray()));
    }


    @Test
    public void shouldReturnUniqueNameFromSpecifiedPageWhenPageInRange() throws Exception {
        PersonService personService = getPersonService("duplicated-surnames-contacts-input.json");
        List<String> expectedPersonList = Arrays.asList("POPESCU", "Z-ULESCU", "X-ULESCU");

        List<String> actualPersonList = personService.getPaginatedPeopleByAge(50, 2);

        assertThat("Expected to contain same people",
                actualPersonList, containsInAnyOrder(expectedPersonList.toArray()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldReturnUniqueNameFromSpecifiedPageWhenPageNotInRange() throws Exception {
        PersonService personService = getPersonService("duplicated-surnames-contacts-input.json");

        List<String> actualPersonList = personService.getPaginatedPeopleByAge(50, 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldReturnUniqueNameFromSpecifiedPageWhenAgeNegative() throws Exception {
        PersonService personService = getPersonService("duplicated-surnames-contacts-input.json");

        List<String> actualPersonList = personService.getPaginatedPeopleByAge(-1, 3);

    }

    @Test
    public void shouldReturnDateDifferenceInYears() throws Exception {
        Person personMock = new Person();
        personMock.setSurname("MARINESCU");
        personMock.setBirthday(new DateBuilder().addYears(0).addMonths(1).build());

        int actual = DateUtil.getDiffYears(personMock.getBirthday(), new Date());
        int expected = -1;

        assertEquals("Expected to be equals", actual, expected);
    }


    private PersonService getPersonService(String fileName) throws Exception {
        List<Person> personList = PersonTestHelper.getPersonList(fileName);
        PersonRepository personRepository = new StubPersonRepository(personList);
        return new PersonServiceImpl(personRepository);
    }
}
