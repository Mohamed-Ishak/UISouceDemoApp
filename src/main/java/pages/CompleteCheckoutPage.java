package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class CompleteCheckoutPage {
    By thankYouMessage = By.cssSelector("h2[class='complete-header']");
    By orderDispatchedMessages = By.cssSelector("div[class='complete-text']");

    private final WebDriver driver;
    private final WaitUtils waitUtils;

    public CompleteCheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }

    public String getThankYouMessage(){
       return  driver.findElement(thankYouMessage).getText();
    }

    public String getOrderDispatchedMessage(){
        return driver.findElement(orderDispatchedMessages).getText();
    }


}
