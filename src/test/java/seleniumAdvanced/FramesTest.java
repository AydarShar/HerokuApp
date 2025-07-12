package seleniumAdvanced;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class FramesTest {

    @Test
    public void framesTest() {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://the-internet.herokuapp.com/frames");
        driver.findElement(By.xpath("//a[text()='iFrame']")).click();
        driver.switchTo().frame("mce_0_ifr");
        assertTrue(driver.findElement(By.xpath("//p[text()='Your content goes here.']")).isDisplayed());
        driver.switchTo().defaultContent();
        driver.quit();
    }
}
