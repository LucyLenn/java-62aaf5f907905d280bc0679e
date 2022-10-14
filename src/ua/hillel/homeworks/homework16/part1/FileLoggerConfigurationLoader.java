package ua.hillel.homeworks.homework16.part1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileLoggerConfigurationLoader {
    private static final Pattern CONFIG_PATTERN = Pattern.compile("^.+?:\\s(.+)$");

    public FileLoggerConfiguration load(String path) {
        List<String> parameters = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                Matcher matcher = CONFIG_PATTERN.matcher(line);
                while (matcher.find()) {
                    parameters.add(matcher.group(1));
                }
            }
        } catch (IOException ex) {
            throw new RuntimeException("Can't read the file", ex);
        }

        if (parameters.size() != 4) {
            throw new IndexOutOfBoundsException(
                    "Check the file against all the parameters. Must be 4 parameters, current: " + parameters.size());
        }

        return new FileLoggerConfiguration(Path.of(parameters.get(0)),
                LoggingLevel.valueOf(parameters.get(1)),
                Integer.parseInt(parameters.get(2)),
                parameters.get(3));
    }
}
