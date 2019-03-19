package training.endava.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import training.endava.app.domain.entity.Person;
import training.endava.app.exception.PersonExceptionNotFoundException;

import training.endava.app.repository.jparepository.PersonRepository;
import training.endava.app.repository.jparepository.PersonRepositoryImpl;
import training.endava.app.service.PersonService;

import java.util.List;

//@Service
//public class PersonServiceImpl implements PersonService {
//
////    private PersonRepository personRepository;
////
////    @Autowired
////    public PersonServiceImpl(PersonRepositoryImpl personRepository) {
////        this.personRepository = personRepository;
////    }
////
////    public void addPerson(Person person) {
////        personRepository.add(person);
////    }
////
////    @Override
////    public Person getPerson(Long id) {
////        return personRepository.findById(id).orElseThrow(() -> new PersonExceptionNotFoundException("Persoana nu exista"));
////    }
////
////    @Override
////    public boolean update(Long id, Person person) {
////        Person personOptional = personRepository.findById(id).
////                orElseThrow(() -> new PersonExceptionNotFoundException("Persoana nu exista"));
////
////        personOptional.setName(person.getName());
////        return true;
////
////
////    }
////
////    public boolean removePerson(Long id) {
////        Person personOptional = personRepository.findById(id).
////                orElseThrow(() -> new PersonExceptionNotFoundException("Persoana nu exista"));
////
////        return personRepository.deletePerson(personOptional);
////
////    }
////
////    @Override
////    public List<Person> getAllPerson() {
////        return personRepository.getPersonList();
////    }
//
//
//}
