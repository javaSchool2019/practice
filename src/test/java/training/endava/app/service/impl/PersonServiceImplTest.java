package training.endava.app.service.impl;

import org.junit.Test;
import training.endava.app.domain.Person;
import training.endava.app.repository.PersonRepository;
import training.endava.app.repository.StubPersonRepository;
import training.endava.app.service.PersonService;
import training.endava.app.test.helpers.PersonTestHelper;

import java.util.Arrays;
import java.util.Collections;
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

    private static final int PAGE_SIZE = PersonServiceImpl.PAGE_SIZE;

    /*
     * A better approach would be mocking PersonRepository.findAll() method to return data, instead of reading from json's,
     * because those json files could change their data and tests will fail.
     */
    @Test
    public void shouldReturnSamePeopleForUniquePersons() throws Exception {
        PersonService personService = getPersonService("unique-contacts-input.json");
        List<String> expectedPersonList = Arrays.asList("MARINESCU", "POPESCU", "IONESCU");

        List<String> actualPersonList = personService.getPeopleSurnamesByAge(50, new Date());

        assertThat("Expected to contain same people",
                actualPersonList, containsInAnyOrder(expectedPersonList.toArray()));
    }

    @Test
    public void shouldReturnUniqueNamesWhenPeopleHaveSameSurname() throws Exception {
        PersonService personService = getPersonService("duplicated-surnames-contacts-input.json");
        List<String> expectedPersonList = Arrays.asList("POPESCU", "MARINESCU", "IONESCU");

        List<String> actualPersonList = personService.getPeopleSurnamesByAge(50, new Date());

        assertThat("Expected to contain same people",
                actualPersonList, containsInAnyOrder(expectedPersonList.toArray()));
    }

    @Test
    public void shouldReturnEmptyListWhenAllPeopleAreYoungerThanInputAge() throws Exception {
        PersonService personService = getPersonService("duplicated-surnames-contacts-input.json");
        List<String> expectedPersonList = Collections.emptyList();

        List<String> actualPersonList = personService.getPeopleSurnamesByAge(130, new Date());

        assertEquals(expectedPersonList, actualPersonList);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldReturnIllegalArgumentExceptionWhenAgeIsNegative() throws Exception {
        PersonService personService = getPersonService("duplicated-surnames-contacts-input.json");
        List<String> expectedPersonList = Collections.emptyList();

        List<String> actualPersonList = personService.getPeopleSurnamesByAge(-3, new Date());

        assertEquals(expectedPersonList, actualPersonList);
    }

    @Test
    public void shouldReturnUniqueNamesWhenPeopleHaveSameNameOnPage() throws Exception {
        PersonService personService = getPersonService("duplicated-surnames-contacts-input.json");
        List<String> expectedPersonList = Arrays.asList("POPESCU", "MARINESCU");

        List<String> actualPersonList = personService.getPaginatedPeopleByAge(30, new Date(), 1);

        assertEquals(expectedPersonList, actualPersonList);
    }

    @Test
    public void shouldReturnAllNamesWhenPeopleHaveUniqueNameOnPage() throws Exception {
        PersonService personService = getPersonService("duplicated-surnames-contacts-input.json");

        List<String> actualPersonList = personService.getPaginatedPeopleByAge(10, new Date(), 2);

        assertEquals(PAGE_SIZE, actualPersonList.size());
    }

    @Test()
    public void shouldReturnUniqueElementsWhenTheLastPageIsNotFull() throws Exception {
        PersonService personService = getPersonService("duplicated-surnames-contacts-input.json");
        List<String> expectedPersonList = Collections.singletonList("NUME6");

        List<String> actualPersonList = personService.getPaginatedPeopleByAge(10, new Date(), 4);

        assertEquals(expectedPersonList, actualPersonList);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void shouldReturnUnsupportedOperationExceptionWhenPageIsGreaterThanListsSizeDividedByPageSize() throws Exception {
        PersonService personService = getPersonService("duplicated-surnames-contacts-input.json");
        personService.getPaginatedPeopleByAge(30, new Date(), 1000);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void shouldReturnUnsupportedOperationExceptionWhenPageIsLowerThanOne() throws Exception {
        PersonService personService = getPersonService("duplicated-surnames-contacts-input.json");
        personService.getPaginatedPeopleByAge(30, new Date(), -1);
    }


    private PersonService getPersonService(String fileName) throws Exception {
        List<Person> personList = PersonTestHelper.getPersonList(fileName);
        PersonRepository personRepository = new StubPersonRepository(personList);
        return new PersonServiceImpl(personRepository);
    }
}
