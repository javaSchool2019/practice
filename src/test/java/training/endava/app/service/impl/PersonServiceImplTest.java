package training.endava.app.service.impl;

import org.junit.Test;
import training.endava.app.domain.Person;
import training.endava.app.repository.PersonRepository;
import training.endava.app.repository.StubPersonRepository;
import training.endava.app.service.PersonService;
import training.endava.app.test.helpers.PersonTestHelper;

import java.util.Arrays;
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

    private PersonService getPersonService(String fileName) throws Exception {
        List<Person> personList = PersonTestHelper.getPersonList(fileName);
        PersonRepository personRepository = new StubPersonRepository(personList);
        return new PersonServiceImpl(personRepository);
    }

    @Test
    public void getPeopleSurnamesByAge() throws Exception {
        PersonService personService = getPersonServicePaginated("contactsPaginatedPeopleByAge.json");
        List<String> expectedPersonListPaginated = Arrays.asList("IONESCU","PISTOL","POPESCOL");
        List<String> actualPersonListPaginated = personService.getPaginatedPeopleByAge(50,2);
        assertThat("Expected to contain same people",
                actualPersonListPaginated, containsInAnyOrder(expectedPersonListPaginated.toArray()));
    }
    @Test (expected = IndexOutOfBoundsException.class)
    public void getPeopleSurnamesByAgeOverNrOfPage() throws Exception {
        PersonService personService = getPersonServicePaginated("contactsPaginatedPeopleByAge.json");
        List<String> expectedPersonListPaginated = Arrays.asList("IONESCU","PISTOL","POPESCOL");
        List<String> actualPersonListPaginated = personService.getPaginatedPeopleByAge(50,1000);
        assertThat("Expected to contain same people",
                actualPersonListPaginated, containsInAnyOrder(expectedPersonListPaginated.toArray()));
    }
    @Test (expected = IndexOutOfBoundsException.class)
    public void getPeopleSurnamesByAgeNegativeNrOfPage() throws Exception {
        PersonService personService = getPersonServicePaginated("contactsPaginatedPeopleByAge.json");
        List<String> expectedPersonListPaginated = Arrays.asList("IONESCU","PISTOL","POPESCOL");
        List<String> actualPersonListPaginated = personService.getPaginatedPeopleByAge(50,-20);
        assertThat("Expected to contain same people",
                actualPersonListPaginated, containsInAnyOrder(expectedPersonListPaginated.toArray()));
    }
    private PersonService getPersonServicePaginated(String filename) throws Exception {
        List<Person> personList = PersonTestHelper.getPersonList(filename);
        PersonRepository personRepository = new StubPersonRepository(personList);
        return new PersonServiceImpl(personRepository);
    }




    @Test
    public void getCurrentDate() {
    }

    @Test
    public void getPaginatedPeopleByAge() {
    }
}
