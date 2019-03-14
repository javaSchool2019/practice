package training.endava.app.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import training.endava.app.exception.PersonAlreadyExistsException;
import training.endava.app.exception.PersonException;

import java.io.IOException;
import java.util.logging.*;

@ControllerAdvice
public class ExceptionHandlerControllerAdvice {

    private static final Logger LOGGER = Logger.getLogger(ExceptionHandlerControllerAdvice.class.getName());
    static {
        try {
            FileHandler fileHandler = new FileHandler("./practice.log");
            Formatter simpleFormatter = new SimpleFormatter();
            LOGGER.addHandler(fileHandler);
            fileHandler.setFormatter(simpleFormatter);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error occur in FileHandler.", e);
        }
        LOGGER.setLevel(Level.ALL);
    }
    @ExceptionHandler(PersonAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    public ErrorResponse handleException(PersonAlreadyExistsException e){
        LOGGER.info(LOGGER.getName() + " "+ e.getMessage());
        return new ErrorResponse(HttpStatus.CONFLICT.value(), e.getMessage());
    }

    @ExceptionHandler(PersonException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    public ErrorResponse handleException(PersonException e){
        LOGGER.info(LOGGER.getName() + " "+ e.getMessage());
        return new ErrorResponse(HttpStatus.CONFLICT.value(), e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorResponse handleExceptionGeneric(Exception e){
        LOGGER.warning(LOGGER.getName() + " "+ e.getMessage());
        return new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
    }
}
