package training.endava.app.logger;

import java.io.IOException;
import java.util.logging.*;

public class MyLogger {
    private static final Logger LOGGER = Logger.getLogger(MyLogger.class.getName());

    private static MyLogger INSTANCE;

    public static MyLogger getInstance()
    {
        if (INSTANCE == null)
        {
            INSTANCE = new MyLogger();
        }
        return  INSTANCE;
    }

    public static void log(Level level, String msg){
        LOGGER.log(level, msg);
        System.out.println(msg);
    }

    public static void log(Level level, String msg, Throwable t){
        LOGGER.log(level, msg, t);
        System.out.println(msg);
    }

    private MyLogger()
    {
        Handler fileHandler;
        try{

            fileHandler  = new FileHandler("./myLogs.log", 8096, 1, true);
            fileHandler.setLevel(Level.ALL);
            fileHandler.setFormatter(new SimpleFormatter());

            LOGGER.addHandler(fileHandler);
            LOGGER.setLevel(Level.ALL);

            LOGGER.config("Configuration done.");

            LOGGER.log(Level.FINE, "Finer logged");
        }catch(IOException exception){
            LOGGER.log(Level.SEVERE, "Error occur in FileHandler.", exception);
        }

        LOGGER.finer("Finest example on LOGGER handler completed.");

    }
}
