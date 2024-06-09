package tests;

import baseTest.BaseTest;
import org.testng.annotations.Test;
import pageObjects.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void testLogin() {

        LoginPage loginPage = new LoginPage(driver);

        String username = configReader.getConfigProperties("username");
        String password = configReader.getConfigProperties("password");

        loginPage.loginJourney(username, password);

    }

}
