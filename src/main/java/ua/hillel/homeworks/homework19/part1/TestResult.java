package ua.hillel.homeworks.homework19.part1;

public class TestResult {
    private int totalCountTests;
    private int countSucceededTests;
    private int countFailedTests;
    private String timeTestStarted;

    public void setTotalCountTests(int totalCountTests) {
        this.totalCountTests = totalCountTests;
    }

    public void setCountSucceededTests(int countSucceededTests) {
        this.countSucceededTests = countSucceededTests;
    }

    public void setCountFailedTests(int countFailedTests) {
        this.countFailedTests = countFailedTests;
    }

    public void setTimeTestStarted(String timeTestStarted) {
        this.timeTestStarted = timeTestStarted;
    }

    @Override
    public String toString() {
        return "TestResult{" +
                "totalCountTests=" + totalCountTests +
                ", countSucceededTests=" + countSucceededTests +
                ", countFailedTests=" + countFailedTests +
                ", timeTestStarted=" + timeTestStarted +
                '}';
    }
}
