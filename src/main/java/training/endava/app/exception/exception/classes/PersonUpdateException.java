package training.endava.app.exception.exception.classes;

public class PersonUpdateException extends PersonNotFound {
    public PersonUpdateException(String message, Integer errorCode) {
        super(message, errorCode);
    }
}
