import logger.Logger;
import logger.fileLogger.FileLogger;
import logger.fileLogger.FileLoggerConfigurationLoader;
import logger.fileLogger.FileMaxSizeReachedException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, FileMaxSizeReachedException {
        Logger logger = new FileLogger();
        logger.debug("some message");
        logger.info("some message 3");
        FileLoggerConfigurationLoader fileLoggerConfigurationLoader = new FileLoggerConfigurationLoader();
        fileLoggerConfigurationLoader.load();
    }
}