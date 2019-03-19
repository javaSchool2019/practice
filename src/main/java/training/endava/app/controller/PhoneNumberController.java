package training.endava.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import training.endava.app.domain.entity.PhoneNumber;
import training.endava.app.payload.mapper.PhoneNumberMapper;
import training.endava.app.repository.jparepository.PhoneNumberRepository;
import training.endava.app.repository.jparepository.PhoneNumberRepositoryImp;

import javax.validation.Valid;

@RestController
@RequestMapping("/personDNtails")
public class PhoneNumberController {
    private PhoneNumberRepository phoneNumberRepository;

    @Autowired
    public PhoneNumberController(PhoneNumberRepositoryImp phoneNumberRepositoryImp) {
        this.phoneNumberRepository = phoneNumberRepositoryImp;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getAll(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(phoneNumberRepository.getById(id), HttpStatus.OK);

    }

    @GetMapping()
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(phoneNumberRepository.getAll(), HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable Long id) {
        PhoneNumber phoneNumber = phoneNumberRepository.getById(id);
        phoneNumberRepository.delete(phoneNumber);
        return new ResponseEntity<>("Entity was removed", HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<?> add(@Valid @RequestBody PhoneNumber phoneNumber) {
        phoneNumberRepository.add(phoneNumber);
        return new ResponseEntity<>(PhoneNumberMapper.INSTANCE.phoneNumberToPhoneNumberDTO(phoneNumber), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePerson(@PathVariable long id, @Valid @RequestBody PhoneNumber phoneNumber) {
        phoneNumber.setId(id);
        phoneNumberRepository.update(phoneNumber);
        return new ResponseEntity<>(PhoneNumberMapper.INSTANCE.phoneNumberToPhoneNumberDTO(phoneNumber), HttpStatus.OK);


    }
}
