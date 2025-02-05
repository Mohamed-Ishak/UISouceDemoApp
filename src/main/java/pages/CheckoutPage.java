package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class CheckoutPage {

    By checkoutPageTitle = By.cssSelector(".title");
    By firstNameField = By.id("first-name");
    By lastNameField = By.id("last-name");
    By postalCodeField = By.id("postal-code");
    By continueBTN = By.id("continue");


    private final WebDriver driver;
    private final WaitUtils waitUtils;


    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }

    public String getCheckoutTitle(){
        waitUtils.waitForElementToBeVisible(checkoutPageTitle);
        return driver.findElement(checkoutPageTitle).getText();
    }

  public void fillTheDisplayedForm(){
      driver.findElement(firstNameField).sendKeys("Mohamed");
      driver.findElement(lastNameField).sendKeys("Ishaq");
      driver.findElement(postalCodeField).sendKeys("216423");
  }

  public void clickOnContinueBTN(){
     driver.findElement(continueBTN).click();
  }
}
