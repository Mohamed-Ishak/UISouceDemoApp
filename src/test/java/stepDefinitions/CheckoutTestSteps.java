package stepDefinitions;

import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.CheckoutPage;
import utils.DriverFactory;

public class CheckoutTestSteps {

    private final WebDriver driver = DriverFactory.getDriver();
    private final CheckoutPage checkoutPage = new CheckoutPage(driver);

    @When("Verify that user is navigated to Checkout page successfully")
    public void assertOnCheckoutPage(){
        Assert.assertEquals( checkoutPage.getCheckoutTitle(),"Checkout: Your Information");
    }

    @When("I Fill the displayed Form")
    public void fillAllFormFields(){
      checkoutPage.fillTheDisplayedForm();
    }

    @When("I click on Continue button")
    public void clickOnContinueButton(){
     checkoutPage.clickOnContinueBTN();
    }
}
