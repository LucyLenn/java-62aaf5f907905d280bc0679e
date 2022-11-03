package ua.hillel.homeworks.homework19.part1;

import ua.hillel.homeworks.homework19.part1.test.SimpleMathLibraryTest;

public class ProjectTestRunner {
    public static void main(String[] args) {
        new TestRunner().startTestClass(SimpleMathLibraryTest.class);
        new TestRunner().startTestClass(SimpleMathLibraryTest.class.getName());
        new TestRunner().startTestFromPackage("ua.hillel.homeworks.homework19.part1.test");

        TestResultParser testResultParser = new TestResultParser();
        System.out.println(testResultParser.parse("testResults.txt"));
    }
}
