package training.endava.app.exception;

public class PersonAlreadyExistsException extends PersonException{
    public PersonAlreadyExistsException(String msg) {
        super(msg);
    }
}
