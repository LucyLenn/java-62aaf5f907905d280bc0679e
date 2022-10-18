package ua.hillel.homeworks.homework16.part2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class FileLoggerWriter implements LoggerWriter {
    private final FileLoggerConfiguration configuration;
    private File file;

    public FileLoggerWriter(LoggerConfiguration configuration) {
        this.configuration = (FileLoggerConfiguration) configuration;
        createNewFile();
    }

    public void write(String message) {
        checkSize(message);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
            bw.write(String.format(
                            configuration.getPattern(),
                            new Date(),
                            configuration.getLogLevel(),
                            message
                    )
            );
            bw.newLine();
            bw.flush();
        } catch (IOException ex) {
            throw new RuntimeException(String.format(
                    "File handling error in writing a message to the logs: %s", file.getAbsolutePath()), ex);
        }
    }

    private void checkSize(String message) {
        if (file.length() + message.length() > configuration.getMaxSize()) {
            createNewFile();
            /*
             * 4-й пункт исключен 6-м:
             * throw new FileMaxSizeReachedException(String.format(
             *   "Max file size: %s, current size: %s, file path: %s",
             *   configuration.getMaxSize(),
             *   file.length(),
             *   file.getAbsolutePath()));
             */
        }
    }

    public void createNewFile() {
        String fileName = String.format("log_%s.txt", LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy.MM.dd_HH.mm.ss")));
        file = new File(configuration.getPath() + File.separator + fileName);
    }
}
