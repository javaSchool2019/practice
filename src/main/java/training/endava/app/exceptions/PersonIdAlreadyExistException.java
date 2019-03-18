package training.endava.app.exceptions;

public class PersonIdAlreadyExistException extends RuntimeException{
    public PersonIdAlreadyExistException(Integer id) {
        super("Person " + id + " already exist!");
    }
}
