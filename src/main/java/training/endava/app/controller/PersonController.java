package training.endava.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import training.endava.app.Logger.LoggerExample;
import training.endava.app.domain.Person;
import training.endava.app.dto.PersonDTO;
import training.endava.app.exceptions.PersonIdAlreadyExistException;
import training.endava.app.exceptions.PersonIdNotExistException;
import training.endava.app.mapper.PersonMapper;
import training.endava.app.service.impl.PersonServiceImpl;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


@RestController
public class PersonController {

    private Logger logger= LoggerExample.returnLogger();

    @Autowired
    private PersonServiceImpl personServiceImpl;


    @GetMapping(value="person/{id}",produces = {MediaType.APPLICATION_XML_VALUE})
    public Person findPersonById(@PathVariable(value = "id") Integer id) {

        logger.log(Level.INFO,"INFO: ");
        try{
            return this.personServiceImpl.getPersonById(id);
        } catch (PersonIdNotExistException e){
            logger.warning("Person with this id was not found!");
            logger.severe("Person with this id was not found!");
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            logger.severe("Unknown person exception");
            throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }

    @GetMapping(value="dto/{id}", produces = {MediaType.APPLICATION_XML_VALUE})
    public PersonDTO findPersonDTOById(@PathVariable(value = "id") Integer id) {

        logger.log(Level.INFO,"INFO: ");
        try{
            Person person = this.personServiceImpl.getPersonById(id);
            return PersonMapper.INSTANCE.personToPersonDTO(person);
        } catch (PersonIdNotExistException e){
            logger.warning("Person with this id was not found!");
            logger.severe("Person with this id was not found!");
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            logger.severe("Unknown person exception");
            throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }

    @GetMapping(value = "/listAll", produces = {MediaType.APPLICATION_XML_VALUE})
    public List<Person> findAllPersons() {

        logger.log(Level.INFO,"INFO: ");
        try{
            return this.personServiceImpl.listAllPersons();
        }catch (Exception e) {
            logger.severe("Unknown person exception");
            throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    @PostMapping(value = "person/insert")
    public @ResponseBody String addPerson(@ModelAttribute Person person) {

        logger.log(Level.INFO,"INFO: ");
        try{
            this.personServiceImpl.addPerson(person);
            return "HTTP POST was called";
        } catch (PersonIdAlreadyExistException e){
            logger.warning("Person already exist!");
            logger.severe("Person already exist!");
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            logger.severe("Unknown person exception");
            throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    @RequestMapping(value = "/insert", method = RequestMethod.POST, produces = MediaType.APPLICATION_XML_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody Person addPersonJsonToXml(@RequestBody Person person) {

        logger.log(Level.INFO,"INFO: ");
        try{
            return this.personServiceImpl.addPerson(person);
        } catch (PersonIdAlreadyExistException e){
            logger.warning("Person already exist!");
            logger.severe("Person already exist!");
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            logger.severe("Unknown person exception");
            throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}


    @PutMapping(value = "/update")
    public @ResponseBody String updatePerson(@ModelAttribute Person person) {

        logger.log(Level.INFO,"INFO: ");
        try{
            this.personServiceImpl.updatePerson(person);
            return "HTTP PUT was called";
        } catch (Exception e) {
            logger.severe("Unknown person exception");
            throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    @DeleteMapping(value="person/{id}")
    public String removePerson(@PathVariable(value = "id") Integer id) {

        logger.log(Level.INFO,"INFO: ");
        try {
        this.personServiceImpl.removePerson(id);
        return "HTTP DELETE was called!";
            } catch (Exception e) {
        logger.severe("Unknown person exception");
        throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
