package utils;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (driver.get() == null) {
            initializeDriver();
        }
        return driver.get();
    }

    private static void initializeDriver() {
        String browser = ConfigReader.getProperty("browser"); // Read from config file

        if (browser.equalsIgnoreCase("chrome")) {
            driver.set(new ChromeDriver());
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver.set(new FirefoxDriver());
        } else {
            throw new RuntimeException("Invalid browser specified in config file");
        }
    }

    public static void closeDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
