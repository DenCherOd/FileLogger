package logger;

public class FileLoggerConfiguration {

    private static String pathToFile = System.getProperty("user.dir") + "/log.txt";
    private static LoggingLevel level = LoggingLevel.DEBUG;
    private static byte maxFileSize = (byte) 10000;
    private static String format = "[#time#] [#level#] [#message#]";

    public static String getPathToFile() {
        return pathToFile;
    }

    public static void setPathToFile(String pathToFile) {
        FileLoggerConfiguration.pathToFile = pathToFile;
    }

    public static LoggingLevel getLevel() {
        return level;
    }

    public static void setLevel(LoggingLevel level) {
        FileLoggerConfiguration.level = level;
    }

    public static byte getMaxFileSize() {
        return maxFileSize;
    }

    public static void setMaxFileSize(byte maxFileSize) {
        FileLoggerConfiguration.maxFileSize = maxFileSize;
    }

    public static String getFormat() {
        return format;
    }

    public static void setFormat(String format) {
        FileLoggerConfiguration.format = format;
    }
}