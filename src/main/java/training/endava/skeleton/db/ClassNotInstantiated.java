package training.endava.skeleton.db;

public class ClassNotInstantiated extends Exception {
    Integer code;

    public ClassNotInstantiated(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
