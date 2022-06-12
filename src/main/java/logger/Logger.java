package logger;

import logger.fileLogger.FileMaxSizeReachedException;

import java.io.FileNotFoundException;

public interface Logger {

    void info(String message) throws FileNotFoundException, FileMaxSizeReachedException;

    void debug(String message) throws FileNotFoundException, FileMaxSizeReachedException;

     default boolean isInfoLevel() {
        return FileLoggerConfiguration.getLevel().getLevelValue() >= LoggingLevel.INFO.getLevelValue();
    }

    default boolean isDebugLevel() {
        return FileLoggerConfiguration.getLevel().getLevelValue() >= LoggingLevel.DEBUG.getLevelValue();
    }
}