import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class TyposTest {

    @Test
    public void checkboxesTest() {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://the-internet.herokuapp.com/typos");
        int count = 0;
        for (int i = 0; i < 10; i++) {
            if (driver.findElement(By.xpath("//div[@id=\"content\"]//p[2]")).getText()
                    .equals("Sometimes you'll see a typo, other times you won,t.")) {
                count++;
            }
            driver.navigate().refresh();
        }
        System.out.println("Из 10 раз " + count + " раза параграф был написан неправильно.");
        driver.quit();
    }
}
