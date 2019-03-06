package training.endava.skeleton.exceptions;

public class CustomPersonException extends RuntimeException {

    public static final int PERSON_NOT_FOUND = 0;
    public static final int PERSON_ALREADY_EXISTS = 1;
    public static final int ILLEGAL_ARGUMENT = 2;

    private int errorCode;

    public CustomPersonException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public CustomPersonException(String message){
        super(message);
    }

    public int getErrorCode() {
        return errorCode;
    }
}
