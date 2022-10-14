package ua.hillel.homeworks.homework16.part1;

import java.nio.file.Path;

// можно было заменить на рекорд, но считаю мне пока рано им пользоваться
// так как на сейчас много уходит времени, чтобы быстро "раскрыть", что же он в себе содержит
public class FileLoggerConfiguration {
    private final Path path;
    private final LoggingLevel logLevel;
    private final int maxSize;
    private final String pattern;

    public FileLoggerConfiguration(Path path, LoggingLevel logLevel, int maxSize, String pattern) {
        this.path = path;
        this.logLevel = logLevel;
        this.maxSize = maxSize;
        this.pattern = pattern;
    }

    public Path getPath() {
        return path;
    }

    public LoggingLevel getLogLevel() {
        return logLevel;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public String getPattern() {
        return pattern;
    }
}

