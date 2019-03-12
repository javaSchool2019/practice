package training.endava.app.exception;

public class PersonAlreadyExistsException extends ParentException{

   public PersonAlreadyExistsException(){
       super();
   }
    public PersonAlreadyExistsException(String message){

        super(message);
    }

}
