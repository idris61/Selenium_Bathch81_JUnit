package A_2_JUnit_Tekrar;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class Q17_KeyboardBaseActionsClassWork extends TestBaseBeforeAfter {
    @Test
    public void KeyboardActions1() {

        // 2 https://www.amazon.com sayfasina gidelim
        driver.get("https://www.amazon.com");

        // 3 Arama kutusuna actions method’larine kullanarak samsung A71 yazdirin ve Enter’a basarak arama yaptirin
        WebElement aramaKutusu = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        Actions actions = new Actions(driver);
        actions.click(aramaKutusu).
                sendKeys("samsung").
                sendKeys(" ").
                keyDown(Keys.SHIFT).
                sendKeys("a").keyUp(Keys.SHIFT).
                sendKeys("7").sendKeys("1").sendKeys(Keys.ENTER).
                perform();

        // 4 aramanin gerceklestigini test edin
        WebElement aramaSonucu = driver.findElement(By.xpath("//div[@class='sg-col-inner']"));
        Assert.assertTrue(aramaSonucu.isDisplayed());

    }
}
