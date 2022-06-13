package logger.fileLogger;

import logger.FileLoggerConfiguration;

import java.io.FileInputStream;
import java.io.IOException;

public class FileLoggerConfigurationLoader {
    private FileLoggerConfiguration fileLoggerConfiguration;

    public FileLoggerConfiguration load(String path) throws IOException {
        fileLoggerConfiguration = new FileLoggerConfiguration();
        FileInputStream fileInputStream = new FileInputStream(FileLoggerConfiguration.getPathToFile());
        int i;
        try {
            while ((i = fileInputStream.read()) != -1) {

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileLoggerConfiguration;
    }
}