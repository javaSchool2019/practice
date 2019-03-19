package training.endava.app.Logger;

import java.io.IOException;
import java.util.logging.*;

public class LoggerExample {
    private static final Logger LOGGER = Logger.getLogger(LoggerExample.class.getName());
    public static Logger returnLogger(){

        final Logger LOGGER = Logger.getLogger(LoggerExample.class.getName());

        try {

            FileHandler fileHandler = new FileHandler("./logTest.log");
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
