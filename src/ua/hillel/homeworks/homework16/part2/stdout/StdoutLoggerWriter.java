package ua.hillel.homeworks.homework16.part2.stdout;

import ua.hillel.homeworks.homework16.part2.LoggerConfiguration;
import ua.hillel.homeworks.homework16.part2.LoggerWriter;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Date;

public class StdoutLoggerWriter implements LoggerWriter {
    private final LoggerConfiguration configuration;

    public StdoutLoggerWriter(LoggerConfiguration configuration) {
        this.configuration = configuration;
    }

    public void write(String message) {
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        pw.println(String.format(
                        configuration.getPattern(),
                        new Date(),
                        configuration.getLogLevel(),
                        message
                )
        );
        pw.flush();
    }
}





