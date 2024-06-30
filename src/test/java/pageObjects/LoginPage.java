package pageObjects;

import baseTest.BaseTest;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.WebDriverUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import resources.ExtentManager;

public class LoginPage extends BasePage {

    protected static final Logger logger = LogManager.getLogger(BaseTest.class);
    ExtentTest extentTest = ExtentManager.createTest("Login Journey");
    WebDriverUtils webDriverUtils = new WebDriverUtils(driver);

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
        logger.info("Launching browser");

        webDriverUtils.enterText(userName, username);
        extentTest.info("Entered Username " + username);

        webDriverUtils.enterText(passWord, password);
        extentTest.info("Entered Password " + password);
        webDriverUtils.waitUntilClickableAndClick(loginBtn);

        extentTest.pass("Login Journey Completed");
        logger.info("Login Journey Completed");


    }
}
