package pages;

import Utility.CommonPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductPage {
    WebDriver driver;
    CommonPage common;

    public ProductPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "item_4_title_link")
    WebElement bagPackItem;
    @FindBy(css = "div.inventory_item_name")
    List<WebElement> allProducts;
    @FindBy(xpath = "//button[contains(text(), 'Add to cart')]" )
    WebElement addToCartButton;
    @FindBy(css = "a.shopping_cart_link")
    WebElement ShoppingCartLink;

    public String checkProducts(){
        return bagPackItem.getText();
    }

    public CartPage getAllProducts(String productName){
        for (int i=0; i< allProducts.size(); i++){
           String productText =  allProducts.get(i).getText();
           if (productText.contains(productName)){
               addToCartButton.click();
               break;
           }
        }
        ShoppingCartLink.click();
        return new CartPage(driver);
    }
    }

