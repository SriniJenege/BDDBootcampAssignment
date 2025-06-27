package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org. junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductPage;
import testBase.TestBaseSetup;
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
    TestBaseSetup testBaseSetup;


    @Given("browser is open")
    public void browser_is_open() throws IOException {
        fs = new FileInputStream(System.getProperty("user.dir") + "//src//test//resource//global.properties");
        prop = new Properties();
        prop.load(fs);
        testBaseSetup = new TestBaseSetup();
        driver = testBaseSetup.initializeDriver();
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
    public void user_enters_the_password(String pass) {
        login.enterPassword(prop.getProperty("password"));
    }

    @When("user clicks the login button")
    public void user_clicks_the_login_button() throws IOException {
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
        Assert.assertEquals("Sauce Labs Backpack", cart.checkItem());
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
       // Assert.assertEquals("Sauce Labs Backpack", checkout.checkProdInformation());
        checkout.clickFinishButton();
        Assert.assertEquals("Thank you for your order!", checkout.checkConfirmationMessage());
        testBaseSetup.closeBrowser();

    }

    @When("user selects Price low to high from the dropdown")
    public void user_selects_price_low_to_high_from_the_dropdown() {
        product.selectListSorter("Price (low to high)");
    }

    @Then("user selects item bike-light")
    public void user_selects_item_bike_light() {
        product.selectBikeLightTitle();

    }

    @Then("user select item fleece-jacket")
    public void user_select_item_fleece_jacket() {
        product.selectShoppingCart();

    }

    @Then("user selects a shopping cart")
    public void user_selects_a_shopping_cart() {
        Assert.assertEquals("Sauce Labs Fleece Jacket", product.getFleeceText());
        Assert.assertEquals("Sauce Labs Bike Light", product.getSauceBikeText());
    }

    @Then("remove item fleece-jacket")
    public void remove_item_fleece_jacket() {
        product.clickRemoveFleece();
    }

    @Then("user selects menu item All items")
    public void user_selects_menu_item() {
        product.clickMenuitem();
    }
    @Then("user select shopping cart")
    public void user_select_shopping_cart() {
        cart = product.selectShoppingCart();
    }
    @Then("user selects a checkout")
    public void clickCheckoutButton(){
        checkout = cart.clickCheckOutButton();
    }
    @Then("user checks tax is $0.80")
    public void user_checks_tax_is() {
       Assert.assertEquals("Tax: $0.80",checkout.checkTax());
    }


}

