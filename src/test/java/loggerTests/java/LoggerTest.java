package loggerTests.java;

import logger.FileLoggerConfiguration;
import logger.fileLogger.FileLoggerConfigurationLoader;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;

public class LoggerTest {
    @Test()
    public void shouldReturnIOException_whenWrongPathWritten(){
        Assertions.assertThrowsExactly(IOException.class, () -> new FileLoggerConfigurationLoader());
    }

    @Test
    public void shouldReturnFileLoggerConfigurationObject_whenCorrecPathWritten() throws IOException {
        FileLoggerConfigurationLoader correctConfigLoader = new FileLoggerConfigurationLoader();
        Assertions.assertInstanceOf(FileLoggerConfiguration.class, correctConfigLoader.load("src/main/resources/config.ini"));
    }
}