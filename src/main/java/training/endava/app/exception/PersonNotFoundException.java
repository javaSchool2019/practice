package training.endava.app.exception;

public class PersonNotFoundException extends ResourceNotFoundException {
    public PersonNotFoundException(String message) {
        super(message);
    }
}
