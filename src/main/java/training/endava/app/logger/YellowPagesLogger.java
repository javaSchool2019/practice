package training.endava.app.logger;

import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.*;

@Component
public class YellowPagesLogger {

    private static final LogManager LOG_MANAGER = LogManager.getLogManager();
    public static final Logger LOGGER = Logger.getLogger(YellowPagesLogger.class.getName());

    static{
        try {
            LOG_MANAGER.readConfiguration(new FileInputStream("./src/main/resources/logger.properties"));

        } catch (IOException exception) {
            LOGGER.log(Level.SEVERE, "Error in loading configuration", exception);
        }
    }
}
