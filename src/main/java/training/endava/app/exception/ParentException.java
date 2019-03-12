package training.endava.app.exception;

public class ParentException extends RuntimeException{
    public ParentException() {
        super("Parent exception");
    }
    public ParentException(String message) {
        super(message);
        System.err.println(message);

    }

}
