package training.endava.app.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import training.endava.app.domain.Person;
import training.endava.app.exception.ParentException;
import training.endava.app.exception.PersonAlreadyExistsException;
import training.endava.app.exception.PersonDoesntExistException;
import training.endava.app.mapStruct.PersonDTO;
import training.endava.app.mapStruct.PersonMapper;
import training.endava.app.repository.PersonRepository;
import training.endava.app.service.PersonService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonRepository repo;

    public Optional<Person> getPersonById (Integer id) throws PersonDoesntExistException {
        if(repo.getPersons().stream().filter(p->p.getId().equals(id)).findFirst().isPresent()) {
            return repo.getPersons().stream().filter(p -> p.getId().equals(id)).findFirst();
        }
        else throw new PersonDoesntExistException();
    }

    public void addPerson(Person person) throws PersonAlreadyExistsException{

        repo.addPerson(person);
    }






    @Override
    public void updatePerson(long id, Person person) {

    }

    @Override
    public void deletePerson(long id) {

    }

    public ResponseEntity updatePerson(Person person) throws PersonDoesntExistException{
        return repo.updatePerson(person);
    }

    public List<PersonDTO> getAllPersons  ()throws ParentException
    {   if(repo.getPersons().size()==0) {
         throw new ParentException();
    }
    else{
        return repo.getPersons().stream().map(PersonMapper.INSTANCE::personToPersonDTO).collect(Collectors.toList());
    }

    }

    public ResponseEntity delete(Integer a) throws PersonDoesntExistException {

        return this.repo.delete(a);

    }

    public List<Person>getAllPersonFromDB(){
        return repo.getAllPersonsFromDbByAge();
    }



    public void addPersonToDataBase(Person person){
        System.out.println("persServ"+person);
        repo.addPersonToDatabase(person);
    }


}