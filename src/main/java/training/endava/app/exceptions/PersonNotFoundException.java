package training.endava.app.exceptions;

import org.springframework.http.HttpStatus;

public class PersonNotFoundException extends BaseException {

    public PersonNotFoundException() {
        super(HttpStatus.NOT_FOUND.getReasonPhrase());
    }

    public PersonNotFoundException(String message) {
        super(message);
    }
}
