package baseTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private final Properties properties = new Properties();
    private final String path = System.getProperty("user.dir");

    public String getConfigProperties(String key) {
        try {
            String config = "/src/test/java/resources/config.properties";
            FileInputStream fileInputStream = new FileInputStream(path + config);
            properties.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties.getProperty(key);
    }

    public String getLocatorsProperties(String key) {
        try {
            String locators = "/src/test/java/resources/config.properties";
            FileInputStream fileInputStream = new FileInputStream(path + locators);
            properties.load(fileInputStream);
            return properties.getProperty(key);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
