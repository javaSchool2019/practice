package training.endava.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import training.endava.app.domain.Person;
import training.endava.app.dto.PersonDTO;
import training.endava.app.mapper.PersonMapper;
import training.endava.app.service.impl.PersonServiceImpl;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private PersonServiceImpl personServiceImpl;


    @GetMapping(value="person/{id}",produces = {MediaType.APPLICATION_XML_VALUE})
    public Person findPersonById(@PathVariable(value = "id") Integer id) {
        return this.personServiceImpl.getPersonById(id);
    }

    @GetMapping(value="dto/{id}", produces = {MediaType.APPLICATION_XML_VALUE})
    public PersonDTO findPersonDTOById(@PathVariable(value = "id") Integer id) {
        Person person = this.personServiceImpl.getPersonById(id);
        return PersonMapper.INSTANCE.personToPersonDTO(person);
    }

    @GetMapping(value = "/listAll", produces = {MediaType.APPLICATION_XML_VALUE})
    public List<Person> findAllPersons() {
        return this.personServiceImpl.listAllPersons();
    }


    @PostMapping(value = "person/insert")
    public @ResponseBody String addPerson(@ModelAttribute Person person) {
        System.out.println(person);
        this.personServiceImpl.addPerson(person);
        return "HTTP POST was called";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST, produces = MediaType.APPLICATION_XML_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody Person addPersonJsonToXml(@RequestBody Person person) {
        System.out.println(person);
        Person result = this.personServiceImpl.addPerson(person);
        return result;
    }


    @PutMapping(value = "/update")
    public @ResponseBody String updatePerson(@ModelAttribute Person person) {
        System.out.println(person);
        this.personServiceImpl.updatePerson(person);
        return "HTTP PUT was called";
    }


    @DeleteMapping(value="person/{id}")
    public String removePerson(@PathVariable(value = "id") Integer id) {
        this.personServiceImpl.removePerson(id);
        return "HTTP DELETE was called!";
    }

}
