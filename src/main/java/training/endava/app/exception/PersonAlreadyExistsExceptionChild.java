package training.endava.app.exception;

public class PersonAlreadyExistsExceptionChild extends PersonAlreadyExistsException {
    public PersonAlreadyExistsExceptionChild(){
        super();
    }

    public PersonAlreadyExistsExceptionChild(String message){
        super(message);
    }
}
