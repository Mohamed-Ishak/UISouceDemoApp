package stepDefinitions;

import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.ProductsPage;
import utils.DriverFactory;

public class ProductTestSteps {
    private final WebDriver driver = DriverFactory.getDriver();
    private final ProductsPage productsPage = new ProductsPage(driver);

    @When("Verify that user is navigated to the product page successfully")
    public void verifyThatProductsPageIsDisplayed(){
     Assert.assertTrue(productsPage.assertOnProductPage());
    }

    @When("Add two most expensive products to the cart")
    public void addTwoMostExpensiveProducts(){
        productsPage.addTwoMostExpensiveProductsToCart();
    }

   @When("I click on the Cart button")
    public void clickOnCartBTN(){
        productsPage.clickCartBTN();
   }


}


