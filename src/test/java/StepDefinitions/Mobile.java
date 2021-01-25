package StepDefinitions;

import PageObjects.LoginPage;
import WebDriverFactory.WebDriverFactory;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Mobile {
    private static WebDriver driver;
    WebDriverFactory wdf;
    LoginPage loginPage;
    boolean hasPassed;


   /*@Before
     public void Setup() {
         System.out.println("-- Running Setup ");
         wdf = new WebDriverFactory();
         driver = wdf.getDriver();
         hasPassed = true;
     }
*/

    @Given("^User is present in Chrome browser homepage$")
    public void user_is_present_in_Chrome_browser_homepage()
    {
       // driver.get("https://qualitestgroup.com/");
        driver.findElement(By.id("i_am_a_link"));
        System.out.println("Sign up page opened");
    }

    @When("^Click on the search textbox and enter the keyword$")
    public void click_on_the_search_textbox_and_enter_the_keyword() {
       driver.findElement(By.id("i_am_a_link")).click();
        System.out.println("Sign up page opened1");

    }

    @Then("^Webpage should open with various sites$")
    public void webpage_should_open_with_various_sites()  {
        System.out.println("Sign up page opened2");

    }

    @Then("^open the particular website and then close the app$")
    public void open_the_particular_website_and_then_close_the_app() {
        System.out.println("Sign up page opened3");
        driver.quit();
    }
}
