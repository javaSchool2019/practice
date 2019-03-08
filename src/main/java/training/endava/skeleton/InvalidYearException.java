package training.endava.skeleton;

public class InvalidYearException extends RuntimeException{
    public InvalidYearException(){
        super();
    }

    public InvalidYearException(String message){
        super(message);
    }
}
