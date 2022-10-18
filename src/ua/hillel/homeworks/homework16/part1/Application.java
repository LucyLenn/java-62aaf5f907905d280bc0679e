package ua.hillel.homeworks.homework16.part1;

import java.util.concurrent.TimeUnit;

public class Application {
    public static void main(String[] args){
        FileLoggerConfigurationLoader configurationLoader = new FileLoggerConfigurationLoader();
        FileLoggerConfiguration configuration = configurationLoader.load("./config.txt");
        FileLogger fileLogger = new FileLogger(configuration);

        // for tests
        for (int i = 0; i < 5; i++) {
            fileLogger.info("info message");
            fileLogger.debug("debug message");

            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException ex) {
                throw new RuntimeException("Interruption occurred during sleep.", ex);
            }
        }
    }
}
