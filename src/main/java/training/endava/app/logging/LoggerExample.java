package training.endava.app.logging;
import org.springframework.beans.factory.annotation.Autowired;
import training.endava.app.repository.PersonRepository;

import java.io.IOException;
import java.util.logging.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerExample {


    public static Logger returnLogger(){

       final Logger LOGGER = Logger.getLogger(LoggerExample.class.getName());

        try {

            FileHandler fileHandler = new FileHandler("logFile" + ".log");
            Handler consoleHandler = new ConsoleHandler();
            LOGGER.addHandler(fileHandler);
            LOGGER.addHandler(consoleHandler);
            fileHandler.setLevel(Level.ALL);
            LOGGER.setLevel(Level.ALL);
            LOGGER.config("Configuration done.");
            LOGGER.log(Level.FINE, "Finer logged");
    }catch(IOException exception){
        LOGGER.log(Level.SEVERE, "Error occur in FileHandler. from class :", exception);
    }

         return LOGGER;

    }



}