package training.endava.skeleton.exceptions;

public class PersonIdNotFoundException extends RuntimeException {
    public PersonIdNotFoundException(Integer id) {
        super("Person " + id + " not exist!");
    }

}
