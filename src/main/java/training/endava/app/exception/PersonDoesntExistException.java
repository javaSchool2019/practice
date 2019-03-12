package training.endava.app.exception;

public class PersonDoesntExistException extends ParentException {
    public PersonDoesntExistException(){
        super();
    }
    public PersonDoesntExistException(String message){

        super(message+"Copil");
    }

}
