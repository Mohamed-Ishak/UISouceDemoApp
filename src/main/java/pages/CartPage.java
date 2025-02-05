package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class CartPage {
    By cartPageTitle = By.cssSelector(".title");
    By firstProductName = By.xpath("//a[@id='item_4_title_link']/div");
    By secondProductName = By.xpath("//a[@id='item_5_title_link']/div");
    By checkoutBTN = By.id("checkout");
    private final WebDriver driver;
    private final WaitUtils waitUtils;


    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }

    public String getCartTitle(){
        waitUtils.waitForElementToBeVisible(cartPageTitle);
        return driver.findElement(cartPageTitle).getText();
    }

    public String getProductFirstName(){
        return driver.findElement(firstProductName).getText();
    }

    public String getProductSecondName(){
        return driver.findElement(secondProductName).getText();
    }

    public void clickOnCheckoutButton(){
        driver.findElement(checkoutBTN).click();
    }
}
