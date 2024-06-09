package commonMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.BasePage;

import java.time.Duration;

public class WaitingMethods extends BasePage {

    private final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

    public WaitingMethods(WebDriver driver) {
        super(driver);
    }

    public void waitUntilClickableAndClick(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

}
