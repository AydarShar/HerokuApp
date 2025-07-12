package seleniumBasic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class CheckboxesTest {

    @Test
    public void checkboxesTest() {

        WebDriver driver = new ChromeDriver();
        SoftAssert softAssert = new SoftAssert();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        WebElement firstCheckbox = driver.findElement(By.xpath("//form[@id=\"checkboxes\"]/input[1]"));
        WebElement secondCheckbox = driver.findElement(By.xpath("//form[@id=\"checkboxes\"]/input[2]"));
        // проверили первый чекбокс
        softAssert.assertFalse(firstCheckbox.isSelected());
        firstCheckbox.click();
        softAssert.assertTrue(firstCheckbox.isSelected());
        // проверили второй чекбокс
        softAssert.assertTrue(secondCheckbox.isSelected());
        secondCheckbox.click();
        softAssert.assertFalse(secondCheckbox.isSelected());
        driver.quit();
        softAssert.assertAll();
    }
}
