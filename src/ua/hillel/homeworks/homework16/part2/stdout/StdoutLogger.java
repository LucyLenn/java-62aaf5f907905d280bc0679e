package ua.hillel.homeworks.homework16.part2.stdout;

import ua.hillel.homeworks.homework16.part2.Logger;
import ua.hillel.homeworks.homework16.part2.LoggerConfiguration;
import ua.hillel.homeworks.homework16.part2.LoggerWriter;
import ua.hillel.homeworks.homework16.part2.LoggingLevel;

public class StdoutLogger implements Logger {
    private final LoggerConfiguration configuration;
    private final LoggerWriter writer;

    public StdoutLogger(LoggerConfiguration configuration) {
        this.configuration = configuration;
        this.writer = new StdoutLoggerWriter(configuration);
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
