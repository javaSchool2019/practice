package training.endava.app.test.helpers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import training.endava.app.domain.Person;

import java.util.List;

public class PersonTestHelper {

    private static ObjectMapper mapper = new ObjectMapper();

    public static List<Person> getPersonList(String fileName) throws Exception {
        String personsJsonString = TestResourceResolver.readFromFile("person-repository", fileName);
        return mapper.readValue(personsJsonString,
                new TypeReference<List<Person>>() {
                });
    }
}
