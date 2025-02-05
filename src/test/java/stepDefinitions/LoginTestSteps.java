package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.LoginPage;
import utils.ConfigReader;
import utils.DriverFactory;

public class LoginTestSteps {


    private final WebDriver driver = DriverFactory.getDriver();
    private final LoginPage loginPage = new LoginPage(driver);

    @Given("I open login page")
    public void IOpenTheLoginPage(){
        driver.navigate().to(ConfigReader.getProperty("url"));
    }

    @When("I enter a username {string}")
    public void IEnterUserName(String userName){
        loginPage.enterUserName(userName);
    }

    @When("I enter a password {string}")
    public void IEnterPassword(String password){
        loginPage.enterPassword(password);
    }

    @When("I click login")
    public void clickLoginBTN(){
        loginPage.clickLogin();
    }

    @Then("I should see an error message")
    public void AnErrorMessageIsDisplayed(){
        Assert.assertTrue(loginPage.assertOnErrorMessage());
    }
}
