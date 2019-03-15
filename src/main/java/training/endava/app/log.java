package training.endava.app;

import java.io.IOException;
import java.util.logging.*;

import java.util.logging.Level;
import java.util.logging.Logger;

public class log {


    public static Logger returnLogger(){

        final Logger LOGGER = Logger.getLogger(log.class.getName());

        try {
            LOGGER.setLevel(Level.ALL);

            FileHandler fileHandler = new FileHandler("logFile" + ".log");
            Handler consoleHandler = new ConsoleHandler();

            LOGGER.addHandler(fileHandler);
            LOGGER.addHandler(consoleHandler);

            fileHandler.setLevel(Level.ALL);

           // LOGGER.config("Configuration done.");

            LOGGER.log(Level.FINE, "Finer logged");

        }catch(IOException exception){
            LOGGER.log(Level.SEVERE, "Error occur in FileHandler. from class :", exception);
        }

        return LOGGER;

    }



}