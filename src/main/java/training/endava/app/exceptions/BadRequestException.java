package training.endava.app.exceptions;

import org.springframework.http.HttpStatus;

public class BadRequestException extends BaseException {

    public BadRequestException() {
        super(HttpStatus.BAD_REQUEST.getReasonPhrase());
    }

    public BadRequestException(String message) {
        super(message);
    }
}
