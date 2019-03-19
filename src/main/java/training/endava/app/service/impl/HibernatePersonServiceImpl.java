package training.endava.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import training.endava.app.domain.Person;
import training.endava.app.domain.hibernateObjects.PageEntry;
import training.endava.app.domain.hibernateObjects.PersonInfo;
import training.endava.app.exception.exception.classes.PersonNotFound;
import training.endava.app.exception.exception.classes.PersonUpdateException;
import training.endava.app.repository.HibernateDB;
import training.endava.app.repository.PersonRepository;
import training.endava.app.service.PersonService;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.*;

@Component
public class HibernatePersonServiceImpl{
    private static final LogManager logManager = LogManager.getLogManager();
    private static final Logger LOGGER = Logger.getLogger("serviceLogger");

    static {
        Handler console = new ConsoleHandler();
        console.setLevel(Level.SEVERE);
        LOGGER.addHandler(console);
    }

    @Autowired
    private HibernateDB hibernateDB;

    public PageEntry getById(Integer id) {

        return hibernateDB.getById(id).orElseThrow(() -> {
            LOGGER.severe("Person with " + id + " not found");
            return new PersonNotFound("Person with " + id + " not found", HttpStatus.NOT_FOUND.value());
        });

    }

    public List<PageEntry> getAll() {
        return hibernateDB.getList();
    }

    public void addNewPersonToDB(PersonInfo personInfo) {
        hibernateDB.add(personInfo);
    }

    public void update(PersonInfo person) {
        hibernateDB.update(person);
    }

    public void delete(Integer id) {
        hibernateDB.delete(id);
    }
}
