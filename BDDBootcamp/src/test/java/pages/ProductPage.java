package pages;

import Utility.CommonPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.List;

public class ProductPage {
    WebDriver driver;
    CommonPage common;
    Select select;



    public ProductPage(WebDriver driver) throws IOException {
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
    @FindBy(css = "select.product_sort_container")
    WebElement productSortContainer;
    @FindBy (css = "button[data-test='add-to-cart-sauce-labs-bike-light']")
    WebElement bikeLightTitle;
    @FindBy (css = "button[data-test='add-to-cart-sauce-labs-fleece-jacket']")
    WebElement fleeceJacket;
    @FindBy(xpath = "//div[normalize-space()='Sauce Labs Bike Light']")
    WebElement sauceLabText;
    @FindBy (xpath = "//div[normalize-space()='Sauce Labs Fleece Jacket']")
    WebElement fleeceJacketText;
    @FindBy (css = "#remove-sauce-labs-fleece-jacket")
    WebElement RemoveFleece;
    @FindBy (css = "#react-burger-menu-btn")
    WebElement menuItem;
    @FindBy(css = "#inventory_sidebar_link")
    WebElement allMenuItem;

    public String checkProducts(){
        return bagPackItem.getText();
    }

    public CartPage getAllProducts(String productName){
        for (int i=0; i< allProducts.size(); i++){
           String productText =  allProducts.get(i).getText();
            System.out.println(productText);
           if(productText.contains(productName)){
               addToCartButton.click();
           }
        }
        ShoppingCartLink.click();
        return new CartPage(driver);
    }
    public void selectListSorter(String text){
        productSortContainer.click();
        select = new Select(productSortContainer);
       select.selectByVisibleText(text);
   }
   public void selectBikeLightTitle(){
          bikeLightTitle.click();
          fleeceJacket.click();

   }
   public CartPage selectShoppingCart(){
       ShoppingCartLink.click();
       return new CartPage(driver);

   }
   public String getSauceBikeText(){
       return sauceLabText.getText();

   }
   public String getFleeceText(){
        return fleeceJacketText.getText();
   }
   public void clickRemoveFleece(){
        RemoveFleece.click();

   }
   public void clickMenuitem(){
        menuItem.click();
        allMenuItem.click();
   }
    }

