package training.endava.app.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import training.endava.app.exception.ParentException;
import training.endava.app.exception.PersonAlreadyExistsException;
import training.endava.app.exception.PersonDoesntExistException;

@ControllerAdvice
public class ExceptionHandleControllerAdvice {



@ExceptionHandler(PersonAlreadyExistsException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse handleException(PersonAlreadyExistsException e){
    return new ErrorResponse(HttpStatus.CONFLICT.value(),e.getMessage());

}


    @ExceptionHandler({ParentException.class,PersonDoesntExistException.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse handleException(ParentException e){
        return new ErrorResponse(HttpStatus.CONFLICT.value(),e.getMessage());

    }


}
