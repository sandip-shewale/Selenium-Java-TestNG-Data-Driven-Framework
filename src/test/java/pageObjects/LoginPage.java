package pageObjects;

import commonMethods.WaitingMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

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
        userName.sendKeys(username);
        passWord.sendKeys(password);
        waitingMethods.waitUntilClickableAndClick(loginBtn);

    }
}
