package pageObjects;

import com.aventstack.extentreports.ExtentTest;
import commonMethods.WaitingMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import resources.ExtentManager;

public class LoginPage extends BasePage {

    ExtentTest extentTest = ExtentManager.createTest("Login Journey");
    WaitingMethods waitingMethods = new WaitingMethods(driver);

    @FindBy(id = "username")
    private WebElement userName;

    @FindBy(id = "password")
    private WebElement passWord;

    @FindBy(id = "login-button")
    private WebElement loginBtn;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void loginJourney(String username, String password) {
        extentTest.info("Launching browser");
        userName.sendKeys(username);
        extentTest.info("Entered Username " + username);
        passWord.sendKeys(password);
        extentTest.info("Entered Password " + password);
        waitingMethods.waitUntilClickableAndClick(loginBtn);
        extentTest.pass("Login Journey Completed");

    }
}
