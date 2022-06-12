package logger.fileLogger;

public class FileMaxSizeReachedException extends Exception {
    public FileMaxSizeReachedException(byte maxSize, byte fileSize, String path) {
        super("File max size reached. Allowable size: " + maxSize +
                " your file size is: " + fileSize + " by path: " + path);
    }
}
