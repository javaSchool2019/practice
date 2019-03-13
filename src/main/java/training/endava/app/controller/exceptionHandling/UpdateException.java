package training.endava.app.controller.exceptionHandling;

import org.springframework.http.HttpStatus;

public class UpdateException extends PersonException{


    public UpdateException() {
        super(HttpStatus.NOT_FOUND.toString());

    }

    public UpdateException(String message) {
        super(message);
    }

}
