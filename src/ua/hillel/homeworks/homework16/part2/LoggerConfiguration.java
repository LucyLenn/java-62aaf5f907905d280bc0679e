package ua.hillel.homeworks.homework16.part2;

public abstract class LoggerConfiguration {
    private final LoggingLevel logLevel;
    private final String pattern;

    public LoggerConfiguration(LoggingLevel logLevel, String pattern) {
        this.logLevel = logLevel;
        this.pattern = pattern;
    }

    public LoggingLevel getLogLevel() {
        return logLevel;
    }

    public String getPattern() {
        return pattern;
    }
}
