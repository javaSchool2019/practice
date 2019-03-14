package training.endava.app.repository;


import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import training.endava.app.domain.Person;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.logging.*;

@Repository
public class PersonRepository {

    private final LogManager logManager = LogManager.getLogManager();
    private final Logger LOGGER = Logger.getLogger("dbLogger");

    private List<Person> list = new ArrayList<Person>();

    public PersonRepository() {
        try {
            FileHandler file = new FileHandler("./src/main/resources/loggerDB.log", true);
            file.setFormatter(new SimpleFormatter());
            file.setLevel(Level.INFO);

            Handler console = new ConsoleHandler();
            console.setLevel(Level.SEVERE);

            LOGGER.addHandler(file);
            LOGGER.addHandler(console);

        } catch (IOException exception) {
            exception.fillInStackTrace();
            LOGGER.log(Level.SEVERE, "Error in loading configuration", exception);
        }
        list.add(new Person("nume1", 1));
        list.add(new Person("nume2", 2));
        list.add(new Person("nume3", 3));
        list.add(new Person("nume4", 4));
        list.add(new Person("nume5", 5));
    }

    public List<Person> getList() {
        LOGGER.info("GetAll from DB");
        return list;
    }

    public void setList(List<Person> list) {
        this.list = list;
    }

    public Optional<Person> getById(Integer id) {
        LOGGER.info("GetById from DB");
        Optional<Person> op = list.stream().filter(y -> y.getId().equals(id)).findFirst();
        return op;
    }

    public void add(Person person) {
        LOGGER.info("Add from DB");
        list.add(person);
    }

    public void update(Person person, Integer i) {
        LOGGER.info("Update from DB");
        list.set(i, person);
    }

    public void delete(Integer personId) {
        LOGGER.info("Delete from DB");
        list.remove(list.get(personId));
    }
}