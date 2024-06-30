package baseTest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import resources.ExtentManager;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected static final Logger logger = LogManager.getLogger(BaseTest.class);
    protected ConfigReader configReader = new ConfigReader();
    protected WebDriver driver;

    @BeforeMethod
    public WebDriver initializeDriver() {

        ExtentManager.getInstance();
        String browser = configReader.getConfigProperties("browser");
        String url = configReader.getConfigProperties("url");

        switch (browser.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                logger.info("Launching chrome browser");
                break;
            case "firefox":
                driver = new FirefoxDriver();
                logger.info("Launching firefox browser");
                break;
            case "edge":
                driver = new EdgeDriver();
                logger.info("Launching edge browser");
                break;
        }
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    @AfterMethod
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
        ExtentManager.endTest();
    }

}
