package ua.hillel.homeworks.homework16.part2.stdout;

import ua.hillel.homeworks.homework16.part2.LoggerConfiguration;
import ua.hillel.homeworks.homework16.part2.LoggingLevel;

public class StdoutLoggerConfiguration extends LoggerConfiguration {
    public StdoutLoggerConfiguration(LoggingLevel logLevel, String pattern) {
        super(logLevel,  pattern);
    }
}
