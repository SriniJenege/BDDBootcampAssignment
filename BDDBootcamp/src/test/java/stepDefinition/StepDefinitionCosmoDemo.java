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

public class StepDefinitionCosmoDemo {
    WebDriver driver;
    TestBaseSetup testBaseSetup;

    @Given("New browser is open")
    public void browser_is_open() throws IOException {
        driver = new FirefoxDriver();
        driver.get("https://cosmocode.io/automation-practice-webtable/");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5000));

    }

    @When("user is on the main landing page")
    public void user_is_on_the_main_page() throws IOException {
        Assert.assertEquals("Automation Practice | WebTable – CosmoCode (Formerly TeachMeSelenium)", driver.getTitle());
    }

    @When("checks {string} is spoken in {string}")
    public void checks_is_spoken_in(String country, String language) {
        CosmoPage cosmopage = new CosmoPage(driver);
        cosmopage.verifyCountryAndLanguage("Argentina", "Spanish");
        driver.quit();

    }

}
