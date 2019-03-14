package training.endava.app.config;

import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

@Component
public class LoggingConfig {
    private static final LogManager logManager = LogManager.getLogManager();
    private static final Logger LOGGER = Logger.getLogger("configLogger");

    static {
        try {
            logManager.readConfiguration(new FileInputStream("src/main/resources/logging.properties"));
        } catch (IOException exception) {
            LOGGER.log(Level.SEVERE, "Error in loading configuration", exception);
        }
    }
}
