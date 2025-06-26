import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class SortableDataTablesTest {

    @Test
    public void sortableDataTablesTest() {

        WebDriver driver = new ChromeDriver();
        SoftAssert softAssert = new SoftAssert();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://the-internet.herokuapp.com/tables");
        softAssert.assertEquals(driver.findElement(By.xpath("//table[@id=\"table1\"]//th[5]/span")).getText(), "Web Site");
        softAssert.assertEquals(driver.findElement(By.xpath("//table[1]//tr[1]//td[5]")).getText(), "http://www.jsmith.com");
        softAssert.assertEquals(driver.findElement(By.xpath("//table//tr[2]//td[3]")).getText(), "fbach@yahoo.com");
        softAssert.assertEquals(driver.findElement(By.xpath("//table[2]//tr[3]//td[1]")).getText(), "Doe");
        driver.quit();
        softAssert.assertAll();
    }
}
