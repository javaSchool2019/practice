package training.endava.app.controller.exceptionHandling;

import org.springframework.http.HttpStatus;

public class GetPerson extends PersonException{

    public GetPerson()
    {
        super(HttpStatus.NOT_FOUND.toString());
    }

    public GetPerson(String message)
    {
        super(message);
    }
}
