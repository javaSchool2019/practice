package training.endava.app.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import training.endava.app.exception.PersonAlreadyExistsException;
import training.endava.app.exception.PersonException;

@ControllerAdvice
public class ExceptionHandlerControllerAdvice {

    @ExceptionHandler(PersonAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    public ErrorResponse handleException(PersonAlreadyExistsException e){
        return new ErrorResponse(HttpStatus.CONFLICT.value(), e.getMessage());
    }

    @ExceptionHandler(PersonException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    public ErrorResponse handleException(PersonException e){
        return new ErrorResponse(HttpStatus.CONFLICT.value(), e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorResponse handleExceptionGeneric(Exception e){
        return new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
    }
}
