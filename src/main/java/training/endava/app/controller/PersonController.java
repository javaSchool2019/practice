package training.endava.app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import training.endava.app.domain.Person;
import training.endava.app.domain.entity.PhoneNumber;
import training.endava.app.payload.mapper.PersonMapper;
import training.endava.app.repository.jparepository.PhoneNumberRepositoryImp;
import training.endava.app.service.PersonService;
import training.endava.app.service.impl.PersonServiceImpl;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    private PersonService personService;

    @Autowired
    private PhoneNumberRepositoryImp phoneNumberRepository;


    @Autowired
    public PersonController(PersonServiceImpl personService) {
        this.personService = personService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getAll(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(PersonMapper.INSTANCE.personToPersonDTO(personService.getPerson(id)), HttpStatus.OK);

    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PhoneNumber> getAll() {
        PhoneNumber phoneNumber = new PhoneNumber("0746542634Test");
        phoneNumber = phoneNumberRepository.getById(2L);
       // phoneNumberRepository.delete(phoneNumber);
        phoneNumber.setNumber("fdsfsdgsgseefsdfsdf");
        phoneNumberRepository.update(phoneNumber);


        System.out.println(phoneNumberRepository.getAll());
        return phoneNumberRepository.getAll();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable Long id) {
        personService.removePerson(id);
        return new ResponseEntity<>("Entity was removed", HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Person> addPerson(@Valid @RequestBody Person person) {
        personService.addPerson(person);
        return new ResponseEntity<>(person, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePerson(@PathVariable long id, @Valid @RequestBody Person person) {
        personService.update(id, person);
        return new ResponseEntity<>("Entity was modified", HttpStatus.OK);


    }


}
