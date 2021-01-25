package StepDefinitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import WebDriverFactory.WebDriverFactory;
import PageObjects.LoginPage;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

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
        loginPage.click_LogInButton();
    }

    @Given("^Login with username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void login_with_username_and_password(String username, String password) {
        System.out.println("---- Step2");
        loginPage.logIn(username,password);



    }

    @When("^Product is selected$")
    public void product_is_selected() {
        System.out.println("---- Step3");
        String actualTitle=driver.getTitle();
        String expectedTitle="My account - My Store";
        assertEquals(actualTitle, expectedTitle);
        System.out.println("Sign up successful");
        //driver.quit();

    }

    @Then("^new contact icon is present on the page$")
    public void new_contact_icon_is_present_on_the_page() {
        System.out.println("---- Step4");
        loginPage.click_LogOutButton();
        driver.quit();
    }


    @Then("^Product successfully checked out$")
    public void product_successfully_checked_out() {
        System.out.println("---- Step6");

    }

    @When("^User enter valid data on the page$")
    public void user_enter_valid_data_on_the_page(DataTable table)  {

        driver.findElement(By.xpath("//*[@id=\'email_create\']")).sendKeys("Dafgdgfhgdhdh4gf67@gmail.com");
        driver.findElement(By.xpath("//*[@id=\'SubmitCreate\']/span")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;
        List<List<String>>data = table.asLists();
        System.out.println(data.get(1).get(1));
        //Enter data
        driver.findElement(By.xpath("//*[@id=\'customer_firstname\']")).sendKeys(data.get(1).get(1));
        driver.findElement(By.xpath("//*[@id=\'customer_lastname\']")).sendKeys(data.get(2).get(1));
        driver.findElement(By.xpath("//*[@id=\'passwd\']")).sendKeys(data.get(3).get(1));
        driver.findElement(By.xpath("//*[@id=\'firstname\']")).sendKeys(data.get(1).get(1));
        driver.findElement(By.xpath("//*[@id=\'lastname\']")).sendKeys(data.get(2).get(1));
        driver.findElement(By.xpath("//*[@id=\'address1\']")).sendKeys(data.get(4).get(1));
        driver.findElement(By.xpath("//*[@id=\'city\']")).sendKeys(data.get(5).get(1));
        Select objState = new Select(driver.findElement(By.xpath("//*[@id=\'id_state\']")));
        objState.selectByIndex(4);
        driver.findElement(By.xpath("//*[@id=\'postcode\']")).sendKeys(data.get(6).get(1));
        driver.findElement(By.xpath("//*[@id=\'phone_mobile\']")).sendKeys(data.get(7).get(1));
        driver.findElement(By.xpath("//*[@id=\'submitAccount\']/span")).click();
        System.out.println("Details filled and new user created");

    }

    @Then("^User registration should be successful\\.$")
    public void user_registration_should_be_successful() {
        String actualTitle=driver.getTitle();
        String expectedTitle="My account - My Store";
        assertEquals(actualTitle, expectedTitle);
        System.out.println("Sign up successful");
        driver.quit();

    }
    @After
    public void Teardown() {
        System.out.println("-- Teardown ");

            System.out.println("Driver Closed ");

    }
}