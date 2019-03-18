package training.endava.app.exceptions;

public class PersonIdNotExistException extends RuntimeException{
    public PersonIdNotExistException(Integer id) {
        super("Person with id = " + id + " was not found!");
    }
}