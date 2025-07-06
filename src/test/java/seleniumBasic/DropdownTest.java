package seleniumBasic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class DropdownTest {

    @Test
    public void dropdownTest() {

        WebDriver driver = new ChromeDriver();
        SoftAssert softAssert = new SoftAssert();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://the-internet.herokuapp.com/dropdown");
        Select select = new Select(driver.findElement(By.id("dropdown")));
        select.selectByVisibleText("Option 1");
        softAssert.assertTrue(Boolean.parseBoolean(driver
                .findElement(By.xpath("//select[@id=\"dropdown\"]/option[text()='Option 1']"))
                .getAttribute("selected")));

        select.selectByVisibleText("Option 2");
        softAssert.assertTrue(Boolean.parseBoolean(driver
                .findElement(By.xpath("//select[@id=\"dropdown\"]/option[text()='Option 2']"))
                .getAttribute("selected")));
        driver.quit();
        softAssert.assertAll();
    }
}
