package training.endava.app.exception.exception.classes;

import training.endava.app.domain.Person;

public class PersonNotFound extends RuntimeException {
   private String message;
   private Integer errorCode;

    public PersonNotFound(String message, Integer errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }
}
