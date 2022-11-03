package ua.hillel.homeworks.homework19.part1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TestResultParser {
    private final List<TestResult> testResults = new ArrayList<>();

    public List<TestResult> parse(String fileName) {
        File file = new File(fileName);
        return parse(file);
    }

    public List<TestResult> parse(Path path) {
        return parse(path.toFile());
    }

    public List<TestResult> parse(File file) {
        List<String> fileContentByLine;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            fileContentByLine = bufferedReader.lines().toList();
        } catch (IOException e) {
            throw new RuntimeException(String.format("File read error in parsing the file of result tests: %s", file.getAbsolutePath()), e);
        }

        if (fileContentByLine.isEmpty()) {
            throw new RuntimeException(String.format("File is empty and do not contain any results of test: %s", file.getAbsolutePath()));
        }

        findAndAddTestResult(fileContentByLine);

        return testResults;
    }

    private void findAndAddTestResult(List<String> fileContentByLine) {
        TestResult testResult = null;

        for (String line : fileContentByLine) {

            if (line.contains("Actual test run time")) {
                testResult = new TestResult();
                testResults.add(testResult);
                testResult.setTimeTestStarted(line.split("=")[1].trim());
            } else if (testResult != null) {

                if (line.contains("tests found")) {
                    testResult.setTotalCountTests(Integer.parseInt(line.replaceAll("\\D", "")));
                } else if (line.contains("tests successful")) {
                    testResult.setCountSucceededTests(Integer.parseInt(line.replaceAll("\\D", "")));
                } else if (line.contains("tests failed")) {
                    testResult.setCountFailedTests(Integer.parseInt(line.replaceAll("\\D", "")));
                }
            }
        }
    }
}
