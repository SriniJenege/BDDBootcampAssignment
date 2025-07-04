package testBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestBaseSetup {
    WebDriver driver;
    FileInputStream fs;
    Properties prop;

    public WebDriver initializeDriver(String key) throws IOException {
        fs = new FileInputStream(System.getProperty("user.dir")+"//src//test//resource//global.properties");
        prop = new Properties();
        prop.load(fs);
        String url = prop.getProperty(key);
        driver = new FirefoxDriver();
        driver.get(url);
        driver.manage().window().maximize();
        return driver;

    }

    public  void closeBrowser(){
        driver.quit();
    }
}
