package stepDefinitions;

import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.CartPage;
import utils.DriverFactory;

public class CartTestSteps {

    private final WebDriver driver = DriverFactory.getDriver();
    private final CartPage cartPage = new CartPage(driver);


    @When("Verify that user is navigated to Cart page successfully")
    public void assertOnCartPage(){
        Assert.assertEquals(cartPage.getCartTitle(),"Your Cart");
    }

    @When("Verify that previous products are selected")
    public void assertOnSelectedProducts(){
      Assert.assertEquals(cartPage.getProductFirstName(),"Sauce Labs Backpack");
      Assert.assertEquals(cartPage.getProductSecondName(),"Sauce Labs Fleece Jacket");
    }

    @When("I click on the Checkout button")
    public void clickOnCheckoutBTN(){
        cartPage.clickOnCheckoutButton();
    }


}
