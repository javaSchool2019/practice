package training.endava.app.exception;

public class PersonDeleteException extends ResourceNotFoundException {
    public PersonDeleteException(String message){
        super(message);
    }
}
