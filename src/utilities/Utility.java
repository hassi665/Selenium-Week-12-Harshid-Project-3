package utilities;

import browserfactory.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Utility extends BaseTest {

    public void clickOnElement(By by) {

        driver.findElement(by).click();
    }

    public void sendTextToElement(By by, String text){
        // Find email eleent
        WebElement emailField = driver.findElement(by);
        // Type email to email field element
        emailField.sendKeys(text);

    }
}
