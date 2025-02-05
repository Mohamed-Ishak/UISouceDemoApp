package pages;

import org.openqa.selenium.*;
import utils.WaitUtils;

import java.util.List;

public class ProductsPage {
    private final WebDriver driver;
    private final WaitUtils waitUtils;

    By productText = By.cssSelector(".title");
    By cartBTN = By.cssSelector(".shopping_cart_link");


    public ProductsPage(WebDriver driver){
        this.driver=driver;
        this.waitUtils = new WaitUtils(driver);
    }

    public boolean assertOnProductPage(){
      //  System.out.println("driver.findElement(productText).getText() = " + driver.findElement(productText).getText());
        return driver.findElement(productText).isDisplayed();
    }

    public void addTwoMostExpensiveProductsToCart() {
       List<WebElement> addToCartButtons = driver.findElements(By.xpath(".//button[contains(text(),'Add to cart')]"));
       if(!addToCartButtons.isEmpty()){
           addToCartButtons.get(0).click();
           addToCartButtons.get(3).click();
       }
    }

    public void clickCartBTN(){
        driver.findElement(cartBTN).click();
    }

}

