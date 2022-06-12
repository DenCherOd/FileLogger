package logger.fileLogger;

import logger.FileLoggerConfiguration;
import logger.Logger;
import logger.LoggingLevel;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static logger.FileLoggerConfiguration.getPathToFile;

public class FileLogger implements Logger {

    public void info(String message) throws FileNotFoundException, FileMaxSizeReachedException {
        if (isInfoLevel()) {
            FileOutputStream fileOutputStream = new FileOutputStream(getPathToFile(), true);
            String info = addRowToFile(FileLoggerConfiguration.getFormat()
                    .replace("#time#", getTimeAndDate())
                    .replace("#level#", LoggingLevel.INFO.getLevelTitle())
                    .replace("#message#", message));

            try {
                fileOutputStream.write(info.getBytes());
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (getFileSize(FileLoggerConfiguration.getPathToFile()) > FileLoggerConfiguration.getMaxFileSize()) {
                throw new FileMaxSizeReachedException(FileLoggerConfiguration.getMaxFileSize(),
                        getFileSize(FileLoggerConfiguration.getPathToFile()), FileLoggerConfiguration.getPathToFile());
            }
        }
    }

    public void debug(String message) throws FileNotFoundException, FileMaxSizeReachedException {
        if (isDebugLevel()) {
            FileOutputStream fileOutputStream = new FileOutputStream(getPathToFile(), true);
            String info = addRowToFile(FileLoggerConfiguration.getFormat()
                    .replace("#time#", getTimeAndDate())
                    .replace("#level#", LoggingLevel.DEBUG.getLevelTitle())
                    .replace("#message#", message));

            try {
                fileOutputStream.write(info.getBytes());
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (getFileSize(FileLoggerConfiguration.getPathToFile()) > FileLoggerConfiguration.getMaxFileSize()) {
            throw new FileMaxSizeReachedException(FileLoggerConfiguration.getMaxFileSize(),
                    getFileSize(FileLoggerConfiguration.getPathToFile()), FileLoggerConfiguration.getPathToFile());
        }
    }

    public String getTimeAndDate() {
        //get current time and date
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return ldt.format(formatter);
    }

    private void createFileIfNeeded() {
        File file = new File(getPathToFile());
        if (file.exists()) {
            if (file.length() >= FileLoggerConfiguration.getMaxFileSize()) {
                FileLoggerConfiguration.setPathToFile(getPathToFile() + "");
            }
        }
        file = new File(getPathToFile());
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String addRowToFile(String row) {
        FileWriter fw;
        try {
            fw = new FileWriter(getPathToFile(), true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(row);
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return row;
    }

    private byte getFileSize(String fileName) {
        byte bytes = 0;
        Path path = Paths.get(fileName);
        try {
            bytes = (byte) Files.size(path);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return bytes;
    }
}