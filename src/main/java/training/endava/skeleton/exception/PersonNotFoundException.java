package training.endava.skeleton.exception;

public class PersonNotFoundException extends Exception {

    private final Integer errorCode;

    public PersonNotFoundException(String message, Integer errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public Integer getErrorCode() {
        return errorCode;
    }
}
