package Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java. time.Duration;

public class CommonPage {
    WebDriver driver;

    public CommonPage(WebDriver driver){
        this.driver = driver;
    }
    public void waitForElementToVisible(By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
