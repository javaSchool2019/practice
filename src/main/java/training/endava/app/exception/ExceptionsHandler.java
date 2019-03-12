package training.endava.app.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import training.endava.app.exception.exception.classes.PersonNotFound;
import training.endava.app.exception.exception.classes.PersonUpdateException;

@ControllerAdvice
public class ExceptionsHandler {


    @ExceptionHandler(PersonNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorResponse exceptionHandlerPersonNotFound(PersonNotFound e) {
        return new ErrorResponse(e.getErrorCode(), e.getMessage());
    }

    @ExceptionHandler(PersonUpdateException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorResponse exceptionHandlerPersonUpdateException(PersonUpdateException e) {
        return new ErrorResponse(e.getErrorCode(), e.getMessage());
    }

}
