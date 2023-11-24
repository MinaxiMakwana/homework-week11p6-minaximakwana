package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterTest extends BaseTest {

    static String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setup(){
        openBrowser(baseUrl);
    }

    @Test
    public void verifyThatSignInPageDisplay(){
        //click on the ‘Create an Account’ link
        //Verify the text ‘Create New Customer Account’

        WebElement CreateAnAccount = driver.findElement(By.linkText("Create an Account"));
        CreateAnAccount.click();

        driver.findElement(By.id("page-title-wrapper")).click();

        //assert statement
        String expectedMessage = "Create New Customer Account";

        String actualMessage = driver.findElement(By.id("page-title-wrapper")).getText();

        Assert.assertEquals("Please try again", expectedMessage, actualMessage);
    }

    @Test
    public void userSholdRegisterAccountSuccessfully(){
        //click on the ‘Create an Account’ link
        WebElement CreateAnAccount = driver.findElement(By.linkText("Create an Account"));
        CreateAnAccount.click();
        //Enter First name
        driver.findElement(By.id("firstname")).sendKeys("abc");
        //Enter last name
        driver.findElement(By.id("lastname")).sendKeys("xyz");

        //Enter email
        driver.findElement(By.id("email_address")).sendKeys("fdsgfgfdghh@gmail.com");
        //Enter password
        driver.findElement(By.id("password")).sendKeys("1234*abcd");
        //Enter Confirm Password
        driver.findElement(By.id("password-confirmation")).sendKeys("1234*abcd");
        //Click on Create an Account button
        driver.findElement(By.xpath("//button/span[text()='Create an Account']")).click();

        //Verify the text 'Thank you for registering with Main Website Store.
        String expectedMessage = "Thank you for registering with Main Website Store";

        String actualMessage = driver.findElement(By.id("message-success")).getText();

        Assert.assertEquals("Your registration not completed", expectedMessage, actualMessage);

        //Click on down aero neare Welcome
        driver.findElement(By.xpath("//*[@class='action switch']")).click();
        //Click on Sign Out link
        driver.findElement(By.xpath("//*[@class='authorization-link']")).click();
        //Verify the text ‘You are signed out’
        driver.findElement(By.xpath("//*[@class='page-title-wrapper']")).getText();

        //assert statement - sign out button
        String expectedMsg = "You are signed out";

        expectedMsg = driver.findElement(By.id("page-title-wrapper")).getText();

        Assert.assertEquals("You are not signed out", expectedMessage, actualMessage);
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
