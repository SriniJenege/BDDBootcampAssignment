package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
    WebDriver driver;

    public CheckoutPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "checkout")
    WebElement checkoutButton;
    @FindBy(id = "first-name")
    WebElement firstName;
    @FindBy(id = "last-name")
    WebElement lastName;
    @FindBy(id = "postal-code")
    WebElement postcode;
    @FindBy(id = "continue")
    WebElement continueButton;
    @FindBy(css = "div.inventory_item_name")
    WebElement checkProductDescription;
    @FindBy(id = "finish")
    WebElement finishButton;
    @FindBy(css = "h2[data-test='complete-header']")
    WebElement confirmMessage;


    public void clickCheckOutButton(){
        checkoutButton.click();
    }
    public void enterFirstname(String name){
        firstName.sendKeys(name);
    }
    public void enterLastName(String lastname){
        lastName.sendKeys(lastname);
    }
    public void enterpostcode(String postalcode){
        postcode.sendKeys(postalcode);
    }
    public void clickContinueBtn(){
        continueButton.click();
    }
    public String checkProdInformation(){
       return checkProductDescription.getText();
    }
    public void clickFinishButton(){
        finishButton.click();
    }
    public String checkConfirmationMessage(){
        return confirmMessage.getText();

    }
}
