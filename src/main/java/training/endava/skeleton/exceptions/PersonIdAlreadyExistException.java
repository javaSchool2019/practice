package training.endava.skeleton.exceptions;

import training.endava.skeleton.model.Person;

public class PersonIdAlreadyExistException extends RuntimeException{
    public PersonIdAlreadyExistException(Integer id) {
        super("Person " + id + " already exist!");
    }

}
