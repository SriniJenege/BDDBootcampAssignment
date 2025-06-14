package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
    WebDriver driver;
    CommonPage common;

    public ProductPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = "span.title")
    WebElement products;
    @FindBy(id = "item_4_title_link")
    WebElement bagPackItem;
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement addToCart;

    By locator = By.id("add-to-cart");

    public String checkProducts(){
        return bagPackItem.getText();
    }
    public CartPage clickBagPackItem(){
        addToCart.click();
        return new CartPage(driver);
    }
}
