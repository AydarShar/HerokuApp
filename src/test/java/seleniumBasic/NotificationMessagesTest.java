package seleniumBasic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class NotificationMessagesTest {

    @Test
    public void notificationMessagesTest() {

        WebDriver driver = new ChromeDriver();
        SoftAssert softAssert = new SoftAssert();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://the-internet.herokuapp.com/notification_message_rendered");
        driver.findElement(By.xpath("//a[contains(text(), 'Click here')]")).click();
        softAssert.assertEquals(
                driver.findElement(By.xpath("//div[@id=\"flash\"]")).getText(),
                "Action unsuccesful, please try again\n" +
                        "×");
        driver.quit();
        softAssert.assertAll();
    }
}
