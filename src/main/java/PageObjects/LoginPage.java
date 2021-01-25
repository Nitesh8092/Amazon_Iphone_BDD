package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private String URL;
    private WebDriver driver;

    public LoginPage(WebDriver driver, String URL) {
        this.driver = driver;
        this.URL = URL;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//*[@id=\'email\']")
    private WebElement _username;

    @FindBy(how = How.XPATH, using = "//*[@id=\'passwd\']")
    private WebElement _password;

    @FindBy(how = How.XPATH, using = "//*[@id=\'SubmitLogin\']/span")
    private WebElement _loginButton;

    @FindBy(how = How.XPATH, using = "//*[@id=\'header\']/div[2]/div/div/nav/div[1]/a")
    private WebElement click_LogIn;

    @FindBy(how = How.XPATH, using = "//*[@id=\'header\']/div[2]/div/div/nav/div[2]/a")
    private WebElement click_LogOut;


    private void enter_username(String username) {
        _username.sendKeys(username);
    }

    private void enter_password(String password) {
        _password.sendKeys(password);
    }

    private void click_loginButton()

    {
        _loginButton.click();
    }

    public void logIn(String username, String password) {
        enter_username(username);
        enter_password(password);
        click_loginButton();
    }

    public void open_LoginPage() {
        driver.get(URL);
    }
    public void click_LogInButton() {
        click_LogIn.click();

    }
    public void click_LogOutButton() {
        click_LogOut.click();

    }
}