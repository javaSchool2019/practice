package training.endava.app.controller.exceptionHandling;

import org.springframework.http.HttpStatus;

public class DeleteException extends PersonException{

    public DeleteException()
    {
        super(HttpStatus.NOT_FOUND.toString());

    }

    public DeleteException(String message)
    {
        super(message);
    }

}
