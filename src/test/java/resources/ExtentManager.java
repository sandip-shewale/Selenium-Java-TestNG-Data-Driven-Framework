package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extentReports;

    public static void getInstance() {
        if (extentReports == null) {
            extentReports = new ExtentReports();
            ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter("test-output/ExtentReport.html");
            extentReports.attachReporter(extentSparkReporter);
        }
    }

    public static ExtentTest createTest(String testName) {
        return extentReports.createTest(testName);
    }

    public static void endTest() {
        extentReports.flush();
    }

}
