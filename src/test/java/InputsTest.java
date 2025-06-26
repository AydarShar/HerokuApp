import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class InputsTest {

    @Test
    public void inputsTest() {

        WebDriver driver = new ChromeDriver();
        SoftAssert softAssert = new SoftAssert();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://the-internet.herokuapp.com/inputs");
        WebElement input = driver.findElement(By.xpath("//input[@type='number']"));
        input.sendKeys("u");
        softAssert.assertEquals(input.getAttribute("value"), "");
        input.sendKeys("&");
        softAssert.assertEquals(input.getAttribute("value"), "");
        input.sendKeys("10");
        softAssert.assertEquals(input.getAttribute("value"), "10");
        input.sendKeys(Keys.ARROW_UP);
        softAssert.assertEquals(input.getAttribute("value"), "11");
        input.sendKeys(Keys.ARROW_DOWN);
        softAssert.assertEquals(input.getAttribute("value"), "10");
        driver.quit();
        softAssert.assertAll();
    }
}
