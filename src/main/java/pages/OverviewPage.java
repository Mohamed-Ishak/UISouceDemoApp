package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class OverviewPage {

    By overviewPageTitle = By.cssSelector(".title");
    By itemsTotalBeforeTaxes = By.cssSelector(".summary_subtotal_label");
    By finishBTN = By.id("finish");

    private final WebDriver driver;
    private final WaitUtils waitUtils;

    public OverviewPage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }

    public String getCheckoutTitle(){
        waitUtils.waitForElementToBeVisible(overviewPageTitle);
        return driver.findElement(overviewPageTitle).getText();
    }

   public double getTotalItemsBeforeTaxes(){
        String totalItems = driver.findElement(itemsTotalBeforeTaxes).getText();
        String totalAmount = totalItems.split("\\$")[1];
       System.out.println("totalAmount = " + totalAmount);
       return Double.parseDouble(totalAmount);
   }

   public String getCurrentURLPage(){
       return driver.getCurrentUrl();
   }

   public void clickTheFinishButton(){
        driver.findElement(finishBTN).click();
   }

}
