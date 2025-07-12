package seleniumBasic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class AddRemoveElementsTest {

    @Test
    public void addRemoveTest() {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        driver.findElement(By.xpath("//div[@id=\"elements\"]/button[1]")).isDisplayed();
        driver.findElement(By.xpath("//div[@id=\"elements\"]/button[2]")).isDisplayed();
        driver.findElement(By.xpath("//button[text()='Delete']")).click();
        driver.findElement(By.xpath("//div[@id=\"elements\"]/button[1]")).isDisplayed();
        driver.quit();
    }
}
