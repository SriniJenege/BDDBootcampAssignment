package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.CosmoPage;
import pages.LoginPage;
import testBase.TestBaseSetup;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class StepDefinitionCosmoDemo {
    WebDriver driver;
    TestBaseSetup testBaseSetup;
    FileInputStream fs;
    Properties prop;
    CosmoPage cosmopage;

    @Given("New browser is open")
    public void browser_is_open() throws IOException {
        fs = new FileInputStream(System.getProperty("user.dir") + "//src//test//resource//global.properties");
        prop = new Properties();
        prop.load(fs);
        testBaseSetup = new TestBaseSetup();
        driver = testBaseSetup.initializeDriver("urlCosmo");
        cosmopage = new CosmoPage(driver);

    }

    @When("user is on the main landing page")
    public void user_is_on_the_main_page() throws IOException {
        Assert.assertEquals("Automation Practice | WebTable – CosmoCode (Formerly TeachMeSelenium)", driver.getTitle());
    }

    @When("checks {string} is spoken in {string}")
    public void checks_is_spoken_in(String country, String language) {
        cosmopage.verifyCountryAndLanguage("Argentina", "Spanish");
        driver.quit();

    }

}
