package training.endava.app.exception;

public class ResourceNotFoundException extends RuntimeException {
    ResourceNotFoundException(String message) {
        super(message);
    }
}
