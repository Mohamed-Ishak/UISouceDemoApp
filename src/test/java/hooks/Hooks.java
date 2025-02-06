package hooks;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Hooks {
    public WebDriver driver;
    private static ExtentReports extentReports;
    private static final ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Before
    public void setupDriver(Scenario scenario) {
        driver = DriverFactory.getDriver(); // Ensure driver is initialized
        driver.manage().window().maximize();

        // Initialize ExtentReports only once
        if (extentReports == null) {
            setupExtentReport();
        }

        // Prevent null scenario name issue
        String scenarioName = (scenario.getName() == null || scenario.getName().trim().isEmpty())
                ? "Unnamed Scenario" : scenario.getName();

        // Assign ExtentTest instance for this scenario
        ExtentTest extentTest = extentReports.createTest(scenarioName);
        test.set(extentTest);
        test.get().info("Starting Scenario: " + scenarioName);
    }

    @After
    public void closeDriver(Scenario scenario) {
        // Capture screenshot if the test fails
        if (scenario.isFailed()) {
            test.get().fail("Test Failed: " + scenario.getName());
            takeScreenshot(scenario);
        } else {
            test.get().pass("Test Passed: " + scenario.getName());
        }

        DriverFactory.closeDriver(); // Close WebDriver after each scenario
    }

    @AfterAll
    public static void tearDownReport() {
        if (extentReports != null) {
            extentReports.flush(); // Flush the report only once after all scenarios
        }
    }

    private void setupExtentReport() {
        extentReports = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("reports/ExtentReports/ExtentReport.html");
        extentReports.attachReporter(spark);
    }

    private void takeScreenshot(Scenario scenario) {
        try {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

            // Ensure directory exists
            File screenshotDir = new File("reports/ExtentReports/");
            if (!screenshotDir.exists()) {
                screenshotDir.mkdirs();
            }

            String screenshotPath = "reports/ExtentReports/" + scenario.getName().replace(" ", "_") + ".png";
            Files.write(Paths.get(screenshotPath), screenshot);
            test.get().addScreenCaptureFromPath(screenshotPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
