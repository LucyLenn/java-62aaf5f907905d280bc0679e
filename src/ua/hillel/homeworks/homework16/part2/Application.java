package ua.hillel.homeworks.homework16.part2;

import java.util.concurrent.TimeUnit;

public class Application {
    public static void main(String[] args) {
        LoggerConfigurationLoader configurationLoader = new FileLoggerConfigurationLoader();
        LoggerConfiguration configuration = configurationLoader.load("./config.txt");
        Logger logger = new FileLogger(configuration);

        // for tests
        for (int i = 0; i < 5; i++) {
            logger.info("info message");
            logger.debug("debug message");

            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException ex) {
                throw new RuntimeException("Some mistake in method 'sleep'", ex);
            }
        }
    }
}
