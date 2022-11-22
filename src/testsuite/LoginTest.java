package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class LoginTest extends Utility {


    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    public String getTextFromElement(By by){
        WebElement actualTextMessageElement = driver.findElement(by);
        return actualTextMessageElement.getText();
    }

    public void sendTextToElement(By by, String text){
        // Find by element
        WebElement emailField = driver.findElement(by);
        // Type email to email field element
        emailField.sendKeys(text);

    }

    @Test
    public void UserSholdLoginSuccessfullyWithValidCredentials(){

        // Input username to username field element
        sendTextToElement(By.name("username"), "tomsmith");

        // Input password to password field element
        sendTextToElement(By.name("password"), "SuperSecretPassword!");

        // find the login button and click on it
        clickOnElement(By.xpath("//button[@class = 'radius']"));

        // This is text from requirement
        String expectedMessage = "Secure Area";

        // find the expected message element
        String actualMessage = getTextFromElement(By.xpath("//h2[contains(text(),'Secure Area')]"));

        // verifying actual and expected message
        Assert.assertEquals(expectedMessage, actualMessage);

        // Print to be sure expecting write message or not
        System.out.println("Expected Message : "+ expectedMessage);

        // Print to be sure about Actual message
        System.out.println("Actual Message : " + actualMessage );

    }

    @Test
    public void verifyTheUsernameErrorMessage(){

        // Input username to username field element
        sendTextToElement(By.name("username"), "tomsmith1");

        // Input password to password field element
        sendTextToElement(By.name("password"), "SuperSecretPassword!");

        // find the login button and click on it
        clickOnElement(By.xpath("//button[@class = 'radius']"));

        // This is text from requirement
        String expectedMessage = "Your username is invalid!\n" + "×";

        // find the expected message element
        String actualMessage = getTextFromElement(By.xpath("//div[contains(text(),\"Your username is invalid!\")]"));

        // verifying actual and expected message
        Assert.assertEquals(expectedMessage, actualMessage);

        // Print to be sure expecting write message or not
        System.out.println("Expected Message : "+ expectedMessage);

        // Print to be sure about Actual message
        System.out.println("Actual Message : " + actualMessage );

    }

    @Test
    public void verifyThePasswordErrorMessage(){

        // Input username to username field element
        sendTextToElement(By.name("username"), "tomsmith");

        // Input password to password field element
        sendTextToElement(By.name("password"), "SuperSecretPassword");

        // find the login button and click on it
        clickOnElement(By.xpath("//button[@class = 'radius']"));

        // This is text from requirement
        String expectedMessage = "Your password is invalid!\n" + "×";

        // find the expected message element
            String actualMessage = getTextFromElement(By.xpath("//div[contains(text(),\"Your password is invalid!\")]"));

        // verifying actual and expected message
        Assert.assertEquals(expectedMessage, actualMessage);

        // Print to be sure expecting write message or not
        System.out.println("Expected Message : "+ expectedMessage);

        // Print to be sure about Actual message
        System.out.println("Actual Message : " + actualMessage );
    }

    @After
    public void testDown(){
        closeBrowser();
    }
}
