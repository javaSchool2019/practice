package training.endava.app.exceptions.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import training.endava.app.exceptions.PersonIdAlreadyExistException;
import training.endava.app.exceptions.PersonIdNotExistException;

@ControllerAdvice
public class ExceptionHandlerControllerAdvice {

    @ExceptionHandler(PersonIdNotExistException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorResponse handleException (PersonIdNotExistException e){
        return new ErrorResponse(HttpStatus.NOT_FOUND.value(),e.getMessage());
    }


    @ExceptionHandler(PersonIdAlreadyExistException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    public ErrorResponse handleException (PersonIdAlreadyExistException e){
        return new ErrorResponse(HttpStatus.CONFLICT.value(),e.getMessage());
    }


//    @ExceptionHandler({Exception.class, RuntimeException.class,PersonIdAlreadyExistException.class})
//    @ResponseStatus(HttpStatus.CONFLICT)
//    @ResponseBody
//    public ErrorResponse handleExceptionGeneric (Exception e){
//        return new ErrorResponse(HttpStatus.CONFLICT.value(),e.getMessage());
//    }


}
