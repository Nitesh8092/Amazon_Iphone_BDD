package StepDefinitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import WebDriverFactory.WebDriverFactory;
import PageObjects.LoginPage;

public class LoginSteps {
    private static WebDriver driver;
    WebDriverFactory wdf;
    LoginPage loginPage;
    boolean hasPassed;

    @Before
     public void Setup() {
         System.out.println("-- Running Setup ");
         wdf = new WebDriverFactory();
         driver = wdf.getDriver();
         hasPassed = true;
     }


    @Given("^Open Page \"([^\"]*)\"$")
    public void openPageUrl(String url) {
        System.out.println("---- Step1");
        loginPage = new LoginPage(driver, url);
        loginPage.open_LoginPage();

    }

    @When("^Search for Iphone product in search bar$")
    public void search_for_Iphone_product_in_search_bar() {
        System.out.println("---- Step2");
        loginPage.search_Iphone();
        loginPage.click_Submit();

    }

    @Then("^Return search result along with price$")
    public void return_search_result_along_with_price() {
        System.out.println("---Step3");
            System.out.println("Prepare to print all results");

        loginPage.printSearchResult();
        driver.quit();

    }
    @After
    public void Teardown() {
        System.out.println("-- Teardown ");

            System.out.println("Driver Closed ");

    }
}