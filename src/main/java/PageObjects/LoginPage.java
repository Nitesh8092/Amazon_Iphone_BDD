package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage {
    private String URL;
    private WebDriver driver;

    public LoginPage(WebDriver driver, String URL) {
        this.driver = driver;
        this.URL = URL;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchText;

    @FindBy(xpath = "//input[@value=\"Go\"]")
    private WebElement submit;

    @FindBy(id = "nav-search")
    private WebElement navSearch;

    @FindBy(id = "atfResults")
    LoginPage searchResults;

    @FindBy(xpath = ".//li[starts-with(@id, 'result_')]")
    List<LoginPage> productItemList;

    @FindBy(xpath = "./div/div[3]/div[1]")
    private WebElement itemDetail;

    @FindBy(xpath = "./div/div[4]/div[1]")
    private WebElement price;

    public void printSearchResult() {
        System.out.println("Prepare to print all results");
        searchResults.printAllItems();
    }


    public void search_Iphone() {
        searchText.sendKeys("Iphone");
    }


    public void open_LoginPage() {
        driver.get(URL);
    }

    public void click_Submit() {
        submit.click();
    }


    public void printAllItems() {
        StringBuilder sb = new StringBuilder();
        sb.append("We found totally ").append(productItemList.size()).append(" items\n");
        int i = 1;
        for (LoginPage LoginPage : productItemList) {
            sb.append(i++);
            sb.append(" ");
            sb.append(getItemDisplayString());
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    public String getItemDisplayString() {
        return "Item: " + itemDetail.getText() + "  price: " + price.getText();
    }

}
