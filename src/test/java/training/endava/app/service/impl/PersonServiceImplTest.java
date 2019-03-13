package training.endava.app.service.impl;

import org.junit.Test;
import training.endava.app.domain.Person;
import training.endava.app.exceptions.IllegalAgeException;
import training.endava.app.repository.PersonRepository;
import training.endava.app.repository.StubPersonRepository;
import training.endava.app.service.PersonService;
import training.endava.app.test.helpers.PersonTestHelper;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.containsInAnyOrder;
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

        // WIll fail because the names are not in order
        //        assertEquals("Expected to contain same people",
        //                expectedPersonList, actualPersonList);
        assertThat("Expected to contain same people",
                actualPersonList, containsInAnyOrder(expectedPersonList.toArray()));
    }

    @Test
    public void shouldReturnUniqueNamesWhenPeopleHaveSameSurname() throws Exception {
        PersonService personService = getPersonService("duplicated-surnames-contacts-input.json");
        List<String> expectedPersonList = Arrays.asList("POPESCU", "MARINESCU", "IONESCU");

        List<String> actualPersonList = personService.getPeopleSurnamesByAge(50);

        assertThat("Expected to contain same people",
                actualPersonList, containsInAnyOrder(expectedPersonList.toArray()));
    }

    @Test
    public void shouldReturnUniqueNameWhenPeopleHaveSameSurnameOnPageOne() throws Exception {
        PersonService personService = getPersonService("duplicated-surnames-contacts-input.json");
        List<String> expectedPersonList = Arrays.asList("POPESCU", "MARINESCU");
        List<String> actualPersonList = personService.getPaginatedPeopleByAge(50, 1);
        assertThat("Expected to contain same people",
                actualPersonList, containsInAnyOrder(expectedPersonList.toArray()));
    }

    @Test
    public void shouldReturnUniqueNameWhenPeopleHaveSameSurnameOnPageTwo() throws Exception {
        PersonService personService = getPersonService("duplicated-surnames-contacts-input.json");
        List<String> expectedPersonList = Arrays.asList("IONESCU");
        List<String> actualPersonList = personService.getPaginatedPeopleByAge(50, 2);
        assertThat("Expected to contain same people",
                actualPersonList, containsInAnyOrder(expectedPersonList.toArray()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldReturnUniqueNameWhenPeopleHaveSameSurnameOnPageTooBig() throws Exception {
        PersonService personService = getPersonService("duplicated-surnames-contacts-input.json");
        personService.getPaginatedPeopleByAge(50, 100);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldReturnUniqueNameWhenPeopleHaveSameSurnameOnPageNegative() throws Exception {
        PersonService personService = getPersonService("duplicated-surnames-contacts-input.json");
        personService.getPaginatedPeopleByAge(50, -1);
    }

    @Test(expected = IllegalAgeException.class)
    public void shouldReturnUniqueNameWhenPeopleHaveSameSurnameOnPageOneButAgeNegative() throws Exception {
        PersonService personService = getPersonService("duplicated-surnames-contacts-input.json");
        personService.getPaginatedPeopleByAge(-1, 1);
    }

    @Test(expected = IllegalAgeException.class)
    public void shouldReturnUniqueNameWhenPeopleHaveSameSurnameOnPageOneButAgeToBig() throws Exception {
        PersonService personService = getPersonService("duplicated-surnames-contacts-input.json");
        personService.getPaginatedPeopleByAge(102, 1);
    }


    private PersonService getPersonService(String fileName) throws Exception {
        List<Person> personList = PersonTestHelper.getPersonList(fileName);
        PersonRepository personRepository = new StubPersonRepository(personList);
        return new PersonServiceImpl(personRepository);
    }
}
