package stepDefinitions;

import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.CheckoutPage;
import pages.OverviewPage;
import utils.DriverFactory;

public class OverviewTestSteps {

    private final WebDriver driver = DriverFactory.getDriver();
    private final OverviewPage overviewPage = new OverviewPage(driver);


    @Then("Verify that user is navigated to Overview page successfully")
    public void assertOnOverviewPage(){
        Assert.assertEquals(overviewPage.getCheckoutTitle(),"Checkout: Overview");
    }

    @Then("Verify the items total amount before taxes")
    public void verifyTotalItemsAmount(){
      Assert.assertEquals(overviewPage.getTotalItemsBeforeTaxes(),79.98);
    }

    @Then("Verify that the URL matches with the expected link")
    public void verifyTheURLIsMatchedCorrectly(){
        Assert.assertEquals(overviewPage.getCurrentURLPage(),"https://www.saucedemo.com/checkout-step-two.html");
    }
    @Then("I click on Finish button")
    public void clickOnFinishBTN(){
       overviewPage.clickTheFinishButton();
    }
}
