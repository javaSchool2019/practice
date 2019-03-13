package training.endava.app.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import training.endava.app.domain.Person;
import training.endava.app.repository.PersonRepository;
import training.endava.app.repository.StubPersonRepository;
import training.endava.app.service.PersonService;
import training.endava.app.test.helpers.PersonTestHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;


/**
 * Write some more tests using the {@link StubPersonRepository}
 * <p/>
 * Try to identify where you can use Mockito for simpler test doubles
 * <p/>
 */
@RunWith(MockitoJUnitRunner.class)
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
        List<String> expectedPersonList = new ArrayList<>(Arrays.asList("POPESCU", "MARINESCU", "IONESCU"));

        List<String> actualPersonList = personService.getPeopleSurnamesByAge(50);

        assertThat("Expected to contain same people",
                actualPersonList, containsInAnyOrder(expectedPersonList.toArray()));
    }

    @Test
    public void shouldReturnAnEmptyList() throws Exception {
        PersonService personService = getPersonService("duplicated-surnames-contacts-input.json");
        List<String> expectedPersonList = new ArrayList<>(Collections.emptyList());

        List<String> actualPersonList = personService.getPeopleSurnamesByAge(1000);

        assertThat("Expected to contain same people",
                actualPersonList, containsInAnyOrder(expectedPersonList.toArray()));
    }

    @Test
    public void shouldReturnAnEmptyListWhenThePersonServiceContainsNoElements() throws Exception {
        PersonService personService = getPersonService("empty-list.json");
        List<String> expectedPersonList = new ArrayList<>(Collections.emptyList());

        List<String> actualPersonList = personService.getPeopleSurnamesByAge(1);

        assertThat("Expected to contain same people",
                actualPersonList, containsInAnyOrder(expectedPersonList.toArray()));
    }

    @Test
    public void shouldReturnUniqueNamesWhenPeopleHaveSameSurnameOnGivenPage() throws Exception {
        PersonService personService = getPersonService("unique-contacts-input-two-pages.json");
        List<String> expectedPersonList = new ArrayList<>(Arrays.asList("POPESCULUS", "MARINESCULUS", "IONESCULUS"));

        List<String> actualPersonList = personService.getPaginatedPeopleByAge(50, 2);

        assertThat("Expected to contain same people",
                actualPersonList, containsInAnyOrder(expectedPersonList.toArray()));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldThrowIndexOutOfBoundExceptionWhenOnGivenPage() throws Exception {
        PersonService personService = getPersonService("unique-contacts-input-two-pages.json");
        List<String> expectedPersonList = new ArrayList<>(Arrays.asList("POPESCULUS", "MARINESCULUS", "IONESCULUS"));

        List<String> actualPersonList = personService.getPaginatedPeopleByAge(50, -1);

        assertThat("Expected to contain same people",
                actualPersonList, containsInAnyOrder(expectedPersonList.toArray()));
    }






    private PersonService getPersonService(String fileName) throws Exception {
        List<Person> personList = PersonTestHelper.getPersonList(fileName);
        PersonRepository personRepository = new StubPersonRepository(personList);
        return new PersonServiceImpl(personRepository);
    }
}
