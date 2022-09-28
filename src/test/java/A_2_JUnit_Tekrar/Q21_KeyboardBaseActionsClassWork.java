package A_2_JUnit_Tekrar;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class Q21_KeyboardBaseActionsClassWork extends TestBaseBeforeAfter {
    @Test
    public void Test1() throws InterruptedException {

        // 1-Bir Class olusturalim KeyboardActions2
        // 2-https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://www.html.com/tags/iframe/");

        // 3-video’yu gorecek kadar asagi inin
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();

        // 4-videoyu izlemek icin Play tusuna basin
        WebElement youtubeFrame = driver.findElement(By.xpath("//iframe[@src='https://www.youtube.com/embed/owsfdh4gxyc']"));
        driver.switchTo().frame(youtubeFrame);
        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']")).click();

        // 5-videoyu calistirdiginizi test edin
        WebElement duraklatButonu = driver.findElement(By.xpath("//*[@title='Duraklat (k)']"));
        Assert.assertTrue(duraklatButonu.isDisplayed());
    }
}
