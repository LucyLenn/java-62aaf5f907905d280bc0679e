package ua.hillel.homeworks.homework16.part2;

import java.nio.file.Path;

public class FileLoggerConfiguration extends LoggerConfiguration {
    private final Path path;
    private final int maxSize;

    public FileLoggerConfiguration(Path path, LoggingLevel logLevel, int maxSize, String pattern) {
        super(logLevel, pattern);
        this.maxSize = maxSize;
        this.path = path;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public Path getPath() {
        return path;
    }
}
