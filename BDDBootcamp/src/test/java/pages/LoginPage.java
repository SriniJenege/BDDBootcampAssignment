package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class LoginPage {
    public WebDriver driver;



    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "user-name")
    WebElement userField;
    @FindBy(id = "password")
    WebElement passwordField;
    @FindBy(id = "login-button")
    WebElement submitBtn;

public void enterUserName(String user){
    userField.sendKeys(user);
}
public void enterPassword(String pass){
    passwordField.sendKeys(pass);
}
public ProductPage clickSubmitButton() throws IOException {
    submitBtn.click();
    return new ProductPage(driver);
}
}
