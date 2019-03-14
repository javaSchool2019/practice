package training.endava.app.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import training.endava.app.exception.PersonAlreadyExistsException;
import training.endava.app.exception.PersonAlreadyExistsExceptionChild;

import static training.endava.app.logger.YellowPagesLogger.LOGGER;

@ControllerAdvice
public class ExceptionHandlerPersonControllerAdvice {

    @ExceptionHandler(PersonAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    public ErrorResponse handlePersonConflict(PersonAlreadyExistsException exception){
        LOGGER.warning("Error adding person, already in the database " + exception);
        return new ErrorResponse(HttpStatus.CONFLICT.value(), "person already exists");
    }

    @ExceptionHandler(PersonAlreadyExistsExceptionChild.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    public ErrorResponse handlePersonConflictUpdate(PersonAlreadyExistsExceptionChild exception){
        LOGGER.warning("Error updating person, already in the database " + exception);
        return new ErrorResponse(HttpStatus.CONFLICT.value(), "person already exists for update");
    }

    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorResponse handleException(Exception e){
        LOGGER.warning("Unexpected error: " + e);
        return new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
    }

}
