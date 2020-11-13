package MyExceptionPackage;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

import java.util.Scanner;

public class MyLogger {
    private final Logger logger = LogManager.getLogger(MyLogger.class);

//    public MyLogger() {
//        setLogLevel();
//    }

    public void log(String message) {
        logger.log(this.logger.getLevel(), message);
    }

    public void info(String message) {
        logger.info(message);
    }

    public void setLogLevel() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter log level");
        String logLevel = sc.next();
        Configurator.setLevel(this.logger.getName(), Level.getLevel(logLevel));
        log(logLevel);
    }
}




