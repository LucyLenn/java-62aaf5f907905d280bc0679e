package ua.hillel.homeworks.homework16.part2;

public class FileLogger implements Logger {
    private final LoggerConfiguration configuration;
    private final LoggerWriter writer;

    public FileLogger(LoggerConfiguration configuration) {
        this.configuration = configuration;
        this.writer = new FileLoggerWriter(configuration);
    }

    @Override
    public void info(String message) {
        if (LoggingLevel.INFO.getLevel() > configuration.getLogLevel().getLevel()) {
            return;
        }
        writer.write(message);
    }

    @Override
    public void debug(String message) {
        if (LoggingLevel.DEBUG.getLevel() > configuration.getLogLevel().getLevel()) {
            return;
        }
        writer.write(message);
    }
}
