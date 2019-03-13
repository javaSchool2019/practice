package training.endava.app.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import training.endava.app.controller.exceptionHandling.DeleteException;
import training.endava.app.controller.exceptionHandling.PersonException;
import training.endava.app.controller.exceptionHandling.UpdateException;


@ControllerAdvice
public class ExceptionHandlerForControlerAdvice {

    @ExceptionHandler(DeleteException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody ErrorResponse handleException(DeleteException e )
    {
        return new ErrorResponse (HttpStatus.NOT_FOUND, e.getMessage());
    }

    @ExceptionHandler({PersonException.class, UpdateException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody ErrorResponse handleException(PersonException e )
    {
        return new ErrorResponse (HttpStatus.NOT_FOUND, e.getMessage());
    }

}
