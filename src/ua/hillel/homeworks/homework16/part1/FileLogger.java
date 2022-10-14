package ua.hillel.homeworks.homework16.part1;

public class FileLogger {
    private final FileLoggerConfiguration configuration;
    private final FileLoggerWriter writer;

    public FileLogger(FileLoggerConfiguration configuration) {
        this.configuration = configuration;
        this.writer = new FileLoggerWriter(configuration);
    }

    public void info(String message) {
        if (LoggingLevel.INFO.getLevel() > configuration.getLogLevel().getLevel()) {
            return;
        }
        writer.write(message);
    }

    public void debug(String message) {
        if (LoggingLevel.DEBUG.getLevel() > configuration.getLogLevel().getLevel()) {
            return;
        }
        writer.write(message);
    }
}
