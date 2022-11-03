package ua.hillel.homeworks.homework19.part1;

import org.junit.platform.engine.discovery.ClassNameFilter;
import org.junit.platform.engine.discovery.DiscoverySelectors;
import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.LauncherSession;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import org.junit.platform.launcher.listeners.TestExecutionSummary;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestRunner {
    private SummaryGeneratingListener listener = new SummaryGeneratingListener();

    public void startTestClass(String testClassName) {
        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
                .selectors(DiscoverySelectors.selectClass(testClassName))
                .build();

        launchRequest(request);
    }

    public void startTestClass(String... testClassNames) {
        for (String className : testClassNames) {
            LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
                    .selectors(DiscoverySelectors.selectClass(className))
                    .build();

            launchRequest(request);
        }
    }

    public void startTestClass(Class<?> testClass) {
        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
                .selectors(
                        DiscoverySelectors.selectClass(testClass))
                .build();

        launchRequest(request);
    }

    public void startTestClass(Class<?>... testClasses) {
        for (Class<?> clazz : testClasses) {
            LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
                    .selectors(DiscoverySelectors.selectClass(clazz))
                    .build();

            launchRequest(request);
        }
    }

    public void startTestFromPackage(String packageName) {
        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
                .selectors(DiscoverySelectors.selectPackage(packageName))
                .filters(ClassNameFilter.includeClassNamePatterns(".*Test"))
                .build();

        launchRequest(request);
    }

    private void launchRequest(LauncherDiscoveryRequest request) {
        try (LauncherSession session = LauncherFactory.openSession()) {
            Launcher launcher = session.getLauncher();
            launcher.registerTestExecutionListeners(listener);
            launcher.execute(request);
        }

        TestExecutionSummary summary = listener.getSummary();
        writeResultToFile(summary);
    }

    private void writeResultToFile(TestExecutionSummary summary) {
        summary.printTo(new PrintWriter(System.out));

        File file = new File("testResults.txt");
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(file, true))) {
            printWriter.println("Actual test run time = " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            summary.printTo(printWriter);
            printWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException("Error in writing results test to file: " + file.getAbsolutePath(), e);
        }
    }
}
