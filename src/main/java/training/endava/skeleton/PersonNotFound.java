package training.endava.skeleton;

public class PersonNotFound extends Exception {
    Integer code;

    public PersonNotFound(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
