package seleniumAdvanced;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class NestedFramesTest {

    @Test
    public void nestedFramesTest() {

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://the-internet.herokuapp.com/frames");
        driver.findElement(By.xpath("//a[text()='Nested Frames']")).click();
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(driver.findElement(By.name("frame-bottom"))));
        driver.switchTo().defaultContent();
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(driver.findElement(By.name("frame-top"))));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(driver.findElement(By.name("frame-left"))));
        driver.switchTo().defaultContent();
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(driver.findElement(By.name("frame-top"))));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(driver.findElement(By.name("frame-right"))));
        driver.switchTo().defaultContent();
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(driver.findElement(By.name("frame-top"))));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(driver.findElement(By.name("frame-middle"))));
        driver.switchTo().defaultContent();
        driver.quit();
    }
}
