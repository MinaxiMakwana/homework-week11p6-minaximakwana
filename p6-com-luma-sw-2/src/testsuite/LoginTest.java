package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    static String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setup(){
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        //Click on ‘Sign In’ link
        WebElement login = driver.findElement(By.linkText("Login"));
        login.click();
        //Enter valid Email
        WebElement email = driver.findElement(By.id("username"));
        email.sendKeys("fdsgfgfdghh@gmail.com");
        //Enter valid Password
        WebElement password = driver.findElement(By.name("Password"));
        password.sendKeys("1234*abcd");
        //Click on ‘Sign In’ button
        driver.findElement(By.id("send2")).click();

        //Verify the ‘Welcome’ text is display
        driver.findElement(By.xpath("//*[@class='logged-in']")).getText();

    }
    @Test
    public void verifyTheErrorMessageWithInvalidCredentials(){
        //Click on ‘Sign In’ link
        WebElement login = driver.findElement(By.linkText("Login"));
        login.click();
        //Enter valid Email
        WebElement email = driver.findElement(By.id("username"));
        email.sendKeys("fdsgfgfdghh@gmail.com");
        //Enter valid Password
        WebElement password = driver.findElement(By.name("Password"));
        password.sendKeys("1234*abcd");
        //Click on ‘Sign In’ button
        driver.findElement(By.id("send2")).click();
        //Verify the error message ‘The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.’
        driver.findElement(By.id("message-error")).getText();
    }
    @Test
    public void userShouldLogOutSuccessfully() {
        //Click on ‘Sign In’ link
        WebElement login = driver.findElement(By.linkText("Login"));
        login.click();
        //Enter valid Email
        WebElement email = driver.findElement(By.id("username"));
        email.sendKeys("fdsgfgfdghh@gmail.com");
        //Enter valid Password
        WebElement password = driver.findElement(By.name("Password"));
        password.sendKeys("1234*abcd");
        //Click on ‘Sign In’ button
        driver.findElement(By.id("send2")).click();
        //Verify the ‘Welcome’ text is display
        driver.findElement(By.xpath("//*[@class='logged-in']")).getText();
        //Click on down aero neare Welcome
        driver.findElement(By.xpath("//*[@class='action switch']")).click();
        //Click on Sign Out link
        driver.findElement(By.xpath("//*[@class='authorization-link']")).click();
        //Verify the text ‘You are signed out’
        driver.findElement(By.xpath("//*[@class='page-title-wrapper']")).getText();

        //assert statement - sign out button
        String expectedtext = "You are signed out";
        String actualtext = "You are signed out";
        expectedtext = driver.findElement(By.id("page-title-wrapper")).getText();
        Assert.assertEquals("You are not signed out", expectedtext, actualtext);
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
