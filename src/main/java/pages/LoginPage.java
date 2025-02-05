package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class LoginPage {

    private WebDriver driver;
    private WaitUtils waitUtils;

    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMessage = By.cssSelector(".error-message-container");

    public LoginPage(WebDriver driver){
        this.driver=driver;
        this.waitUtils = new WaitUtils(driver);
    }

    public void enterUserName(String userName){
        waitUtils.waitForElementToBeVisible(usernameField);
        driver.findElement(usernameField).sendKeys(userName);
    }

    public void enterPassword(String password){
        waitUtils.waitForElementToBeVisible(passwordField);
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin(){
        waitUtils.waitForElementToBeVisible(loginButton);
        driver.findElement(loginButton).click();
    }

    public boolean assertOnErrorMessage(){
       // waitUtils.waitForElementToBeVisible(errorMessage);
        return driver.findElement(errorMessage).isDisplayed();
    }
}
