package training.endava.skeleton.exception;

public enum ErrorCode {
    PERSON_ALREADY_EXISTS_OR_NULL(-1),
    ID_NOT_FOUND(-2),
    ;
    private final Integer value;

    ErrorCode(int i) {
        this.value = i;
    }

    public Integer getValue() {
        return value;
    }
}
