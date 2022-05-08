package logger.fileLogger;

import logger.FileLoggerConfiguration;

import java.io.FileInputStream;
import java.io.IOException;

public class FileLoggerConfigurationLoader {
    private FileLoggerConfiguration fileLoggerConfiguration;

    public FileLoggerConfiguration load() throws IOException {
        fileLoggerConfiguration = new FileLoggerConfiguration();
        FileInputStream fileInputStream = new FileInputStream(FileLoggerConfiguration.getPathToFile());
        int i;
        while ((i = fileInputStream.read()) != -1) {

        }
        return fileLoggerConfiguration;
    }
}