package tests;

import baseTest.BaseTest;
import commonMethods.ReadWriteXLSXFile;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LoginPage;

import java.util.Map;

public class LoginTest extends BaseTest {


    @DataProvider(name = "excelDataReader")
    public Object[][] excelDataReader() {
        String path = System.getProperty("user.dir") + "/src/test/java/resources/testdata.xlsx";
        Map<Object, Object> dataMap = ReadWriteXLSXFile.readXLSXFileData(path, "login");
        return dataMap.entrySet()
                .stream()
                .map(entry -> new Object[]{entry.getKey(), entry.getValue()})
                .toArray(Object[][]::new);
    }

    @Test(dataProvider = "excelDataReader")
    public void testLogin(String username, String password) {

        LoginPage loginPage = new LoginPage(driver);

        // Get values from .properties file
        // String username = configReader.getConfigProperties("username");
        // String password = configReader.getConfigProperties("password");

        // Read value from .xlsx excel file

        loginPage.loginJourney(username, password);

    }

}
