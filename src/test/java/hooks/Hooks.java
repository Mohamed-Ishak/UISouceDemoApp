package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;

public class Hooks {
    public WebDriver driver;

    @Before
    public void setupDriver() {
        driver = DriverFactory.getDriver(); // Ensure driver is initialized
        driver.manage().window().maximize();
    }

    @After
    public void closeDriver() {
        DriverFactory.closeDriver(); // Ensure driver is properly closed after each scenario
    }
}
