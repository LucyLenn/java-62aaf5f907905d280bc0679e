package ua.hillel.homeworks.homework16.part2.stdout;

import ua.hillel.homeworks.homework16.part2.LoggerConfigurationLoader;
import ua.hillel.homeworks.homework16.part2.LoggingLevel;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StdoutLoggerConfigurationLoader implements LoggerConfigurationLoader {
        private static final Pattern CONFIG_PATTERN = Pattern.compile("^.+?:\\s(.+)$");

        public StdoutLoggerConfiguration load(String path) {
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

            if (parameters.size() != 2) {
                throw new IndexOutOfBoundsException(
                        "Check the file against all the parameters. Must be 2 parameters, current: " + parameters.size());
            }

            return new StdoutLoggerConfiguration(LoggingLevel.valueOf(parameters.get(0)),
                    parameters.get(1));
        }
}
