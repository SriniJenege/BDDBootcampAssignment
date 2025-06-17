package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org. junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class StepDefinitionSauceDemo {
    WebDriver driver;
    FileInputStream fs;
    Properties prop;
    LoginPage login;
    ProductPage product;
    CartPage cart;
    CheckoutPage checkout;

    @Given("browser is open")
    public void browser_is_open() throws IOException {
        fs = new FileInputStream(System.getProperty("user.dir")+"//src//test//resource//global.properties");
        prop = new Properties();
        prop.load(fs);
        String url = prop.getProperty("url");
        driver = new FirefoxDriver();
        driver.get(url);
        driver.manage().window().maximize();
        login = new LoginPage(driver);
    }
    @When("user is on the main page")
    public void user_is_on_the_main_page() {
        //System.out.println(System.getProperty("user.dir"));
        Assert.assertEquals("Swag Labs", driver.getTitle());
    }
    @When("user enters the {string}")
    public void user_enters_the_username(String user) {
        login.enterUserName(prop.getProperty("email"));
    }
    @When("user enter the {string}")
    public void user_enters_the_password(String pass){
        login.enterPassword(prop.getProperty("password"));
    }
    @When("user clicks the login button")
    public void user_clicks_the_login_button() {
        //Returns the object of productPage
        product = login.clickSubmitButton();
    }
    @When("user selects item backpack")
    public void user_selects_item_item() {
       Assert.assertEquals("Sauce Labs Backpack", product.checkProducts());
        //Returns the object of cartPage
        cart = product.getAllProducts("Sauce Labs Backpack");
    }
    @Then("user selects shopping cart")
    public void user_selects_shopping_cart() {
        Assert.assertEquals("Sauce Labs Backpack",cart.checkItem());
        Assert.assertEquals("$29.99", cart.checkPrice());
        //Returns the object of checkoutPage
        checkout = cart.clickCartContainer();
    }
    @Then("user selects checkout")
    public void user_selects_checkout() {
        checkout.clickCheckOutButton();
    }
    @Then("user enters First Name {string}")
    public void user_enters_first_name(String name) {
       checkout.enterFirstname(prop.getProperty("firstname"));
    }
    @Then("user enters Last Name {string}")
    public void user_enters_last_name(String last) {
       checkout.enterLastName(prop.getProperty("lastname"));
    }
    @Then("user enters Postal Code {string}")
    public void user_enters_postal_code(String postcode) {
       checkout.enterpostcode(prop.getProperty("postcode"));
    }
    @Then("user clicks continue")
    public void user_clicks_continue() {
       checkout.clickContinueBtn();
    }
    @Then("user clicks finish")
    public void user_clicks_finish() {
        Assert.assertEquals("Sauce Labs Backpack", checkout.checkProdInformation());
        checkout.clickFinishButton();
        Assert.assertEquals("Thank you for your order!",checkout.checkConfirmationMessage());
        driver.quit();
    }
}

