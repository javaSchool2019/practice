package training.endava.app.exception.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import training.endava.app.exception.ResourceNotFoundException;

import java.util.logging.Logger;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger LOGGER = Logger.getLogger(GlobalExceptionHandler.class.getName());

    @ExceptionHandler(value = ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    protected ErrorResponse handleResourceNotFoundException(ResourceNotFoundException ex) {
        LOGGER.warning(HttpStatus.NOT_FOUND + ": " + ex.getMessage());
        return new ErrorResponse(ex.getMessage(), HttpStatus.NOT_FOUND.value());
    }

}
