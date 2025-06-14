package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    WebDriver driver;

    public CartPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "shopping_cart_container")
    WebElement cartContainer;
    @FindBy(linkText = "Sauce Labs Backpack")
    WebElement bagPackItem;
    @FindBy(css = "div.inventory_item_price")
    WebElement checkPrice;

    public String checkItem(){
        return bagPackItem.getText();
    }
    public String checkPrice(){
        return checkPrice.getText();
    }
    public CheckoutPage clickCartContainer(){
        cartContainer.click();
        return new CheckoutPage(driver);
    }
}
