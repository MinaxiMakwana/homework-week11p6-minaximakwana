package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SaleTest  extends BaseTest {

    static String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setup(){
        openBrowser(baseUrl);
    }

    public void verifyTheTotalItemsDisplayedOnTheWomensJacketsPage(){
        //Click on ‘Sale’ Menu tab
        driver.findElement(By.id("ui-id-8")).click();
        //Click on ‘Jackets’ link on left side under WOMEN’S DEAL Category
        driver.findElement(By.xpath("//ul[@class='items'][1]/li[@class='item']/a[text()='Jackets']")).click();
        // Verify the text ‘Jackets’ is displayed
        driver.findElement(By.id("page-title-wrapper")).getText();

        // Count the Total Item Displayed on Page and print the name of all items into consol
        //Verify total 12 Items displayed on page
        List<WebElement> NoOfJackets = driver.findElements(By.xpath("//*[@class='item product product-item']"));
        NoOfJackets.size();

    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
