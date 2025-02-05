package stepDefinitions;

import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.CompleteCheckoutPage;
import utils.DriverFactory;

public class CompleteCheckoutTestSteps {

    private final WebDriver driver = DriverFactory.getDriver();
    private final CompleteCheckoutPage completeCheckoutPage = new CompleteCheckoutPage(driver);

    @Then("Verify Thank you and Order has been dispatched messages")
    public void verifyThatExpectedCompleteCheckoutMessagesAreDisplayed(){
        Assert.assertEquals(completeCheckoutPage.getThankYouMessage(),"Thank you for your order!");
        Assert.assertEquals(completeCheckoutPage.getOrderDispatchedMessage(),"Your order has been dispatched, and will arrive just as fast as the pony can get there!");
    }
}
