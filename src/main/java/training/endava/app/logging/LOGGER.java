package training.endava.app.logging;

import training.endava.app.service.impl.PersonServiceImpl;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;

import java.util.HashMap;
import java.util.Map;

public class LOGGER {
    private static Map<String,Logger> loggers = new HashMap<>();
    private static String currentDate = "";
    private static boolean createAnotherFile = false;
    private static FileHandler currentFileHandler = null;

    private static String getCurrentDateFileName(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd");
        Date date = new Date();
        String toReturn = "logs/log_" + dateFormat.format(date) + ".log";
        if(!currentDate.equals(toReturn)){
            createAnotherFile = true;
            currentDate = toReturn;
        }
        return toReturn;
    }

    public static Logger getInstance(String className){
        if(loggers.containsKey(className)){
            return loggers.get(className);
        }else{
            Logger logger = Logger.getLogger(className);
            loggers.put(className, logger);
            return logger;
        }
    }

    public static Logger getInstanceWithFileHandler(String className){
        if(loggers.containsKey(className)){
            return loggers.get(className);
        }else{
            Logger logger = Logger.getLogger(className);
            loggers.put(className, logger);
            if(logger.getHandlers().length==0)
                setFileHandler(className);
            return logger;
        }
    }

    public static boolean setFileHandler(String className, String fileName){
        if(!loggers.containsKey(className)){
            return false;
        }else if(loggers.get(className).getHandlers().length!=0){
            return false;
        }
        try {
            File logDir = new File("./logs/");
            if( !(logDir.exists()) )
                logDir.mkdir();

            FileHandler fh = new FileHandler(fileName + ".log",true);
            loggers.get(className).addHandler(fh);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public static boolean setFileHandler(String className){
        if(!loggers.containsKey(className)){
            return false;
        }else if(loggers.get(className).getHandlers().length!=0){
            return false;
        }
        try {
            File logDir = new File("./logs/");
            if( !(logDir.exists()) )
                logDir.mkdir();
           String name = LOGGER.getCurrentDateFileName();
           if(createAnotherFile){
               FileHandler fh = new FileHandler(name);
               currentFileHandler = fh;
               loggers.get(className).addHandler(fh);
               createAnotherFile = false;
               return true;
           }else{
               loggers.get(className).addHandler(currentFileHandler);
               return true;
           }

        } catch (IOException e) {
            return false;
        }
    }
}
