package training.endava.skeleton.exception;

public class PersonNotFoundException extends RuntimeException {

    private final ErrorCode errorCode;

    public PersonNotFoundException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public Integer getErrorCode() {
        return errorCode.getValue();
    }
}
