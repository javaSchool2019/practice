package training.endava.skeleton;

public class PersonAlreadyExists extends Exception {
    Integer code;
    public PersonAlreadyExists(String message,Integer code){
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
