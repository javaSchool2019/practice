package training.endava.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import training.endava.app.domain.entity.PersonDetails;
import training.endava.app.payload.mapper.PersonDetailsMapper;
import training.endava.app.repository.jparepository.PersonDetailsRepository;
import training.endava.app.repository.jparepository.PersonDetailsRepositoryImpl;

import javax.validation.Valid;

@RestController
@RequestMapping("/personDetails")
public class PersonDetailsController {

    private PersonDetailsRepository personDetailsRepository;

    @Autowired
    public PersonDetailsController(PersonDetailsRepositoryImpl personDetailsRepository) {
        this.personDetailsRepository = personDetailsRepository;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getAll(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(personDetailsRepository.getById(id), HttpStatus.OK);

    }

    @GetMapping()
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(personDetailsRepository.getAll(), HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable Long id) {
        PersonDetails personDetails = personDetailsRepository.getById(id);
        personDetailsRepository.delete(personDetails);
        return new ResponseEntity<>("Entity was removed", HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<?> add(@Valid @RequestBody PersonDetails personDetails) {
        personDetailsRepository.add(personDetails);
        return new ResponseEntity<>(PersonDetailsMapper.INSTANCE.personDetailsTopersonDetailsDTO(personDetails), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePerson(@PathVariable long id, @Valid @RequestBody PersonDetails personDetails) {
        personDetails.setId(id);
        personDetailsRepository.update(personDetails);
        return new ResponseEntity<>(PersonDetailsMapper.INSTANCE.personDetailsTopersonDetailsDTO(personDetails), HttpStatus.OK);


    }
}
