import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class HoversTest {

    @Test
    public void hoversTest() {

        WebDriver driver = new ChromeDriver();
        Actions action = new Actions(driver);
        SoftAssert softAssert = new SoftAssert();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://the-internet.herokuapp.com/hovers");
        WebElement we = driver.findElement(By.xpath("//img[@src=\"/img/avatar-blank.jpg\"]"));
        action.moveToElement(we).moveToElement(driver.findElement(By.xpath("//a[@href=\"/users/1\"]")))
                .click().build().perform();
        softAssert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/users/1");
        softAssert.assertEquals(driver.findElement(By.xpath("//h1")).getText(), "Not Found");
        driver.quit();
        softAssert.assertAll();
    }
}
