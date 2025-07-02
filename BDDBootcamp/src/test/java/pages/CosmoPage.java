package pages;

// Given When user is on the main page
// When user is on the main page "https://cosmocode.io/automation-practice-webtable/"
// And checks "Spanish" is spoken in "Argentina"
// And List of Countries, Capitals, Currencies and Languages   Visited Country Capital(s) Currency Primary Language(s) Afghanistan Kabul Afghani Dari Persian; Pashto Albania Tirane Lek Albanian Alger…

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;

public class CosmoPage {
    WebDriver driver;

    public CosmoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#countries tbody tr:nth-child(8)")
    List<WebElement> elementsInOneRow;

    public void verifyCountryAndLanguage(String country, String language) {
        for (int i = 0; i < elementsInOneRow.size(); i++) {
            String text = elementsInOneRow.get(i).getText();
            System.out.println(text);

            // To split a string by whitespace and print the first and last words, use split("\\s+")
            // and access the first and last elements of the resulting array.
            String[] parts = text.split("\\s+");
            if (parts[0].equalsIgnoreCase(country))
            System.out.println("First: " + parts[0]);
            if (parts[parts.length - 1].equalsIgnoreCase(language))
            System.out.println("Last: " + parts[parts.length - 1]);
        }
    }
}


