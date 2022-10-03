package A_2_JUnit_Tekrar;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBaseBeforeAfter;

import java.time.Duration;

public class Q28_IframeHomeworkWork extends TestBaseBeforeAfter {
    @Test
    public void test() {
        // 1. “http://webdriveruniversity.com/IFrame/index.html”sayfasina gidin
        driver.get("http://webdriveruniversity.com/IFrame/index.html");

        // 2. “Our Products” butonuna basin
        WebElement iframe = driver.findElement(By.xpath("//*[@id='frame']"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("//*[text()='Our Products']")).click();

        // 3. “Cameras product”i tiklayin
        driver.findElement(By.xpath("(//p[@class='sub-heading'])[2]")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-body']")));

        String popUp = driver.findElement(By.xpath("//div[@class='modal-body']")).getText();

        // 4. Popup mesajini yazdirin
        System.out.println(popUp);

        // 5. “close” butonuna basin
        driver.findElement(By.xpath("(//button[@class='btn btn-default'])[2]")).click();
        driver.switchTo().defaultContent();  //en üstteki switch'e çıkmak için kullanılır

        // 6. "WebdriverUniversity.com (IFrame)" linkini tiklayin
        driver.findElement(By.xpath("(//a[@id='nav-title'])[1]")).click();

        // 7. "http://webdriveruniversity.com/index.html" adresine gittigini testedin
        Assert.assertTrue(driver.findElement(By.xpath("//a[@id='nav-title']")).isDisplayed());
    }
}
