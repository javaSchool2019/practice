package training.endava.app.exceptions;

import org.springframework.http.HttpStatus;

public class PersonAlreadyExists extends BaseException {

    public PersonAlreadyExists() {
        super(HttpStatus.CONFLICT.getReasonPhrase());
    }

    public PersonAlreadyExists(String message) {
        super(message);
    }
}
