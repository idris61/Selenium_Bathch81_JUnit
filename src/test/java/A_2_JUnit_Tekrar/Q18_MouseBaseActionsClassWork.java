package A_2_JUnit_Tekrar;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class Q18_MouseBaseActionsClassWork extends TestBaseBeforeAfter {
    @Test
    public void MouseActions4() throws InterruptedException {

        // 1- https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com");

        // 2- Yeni hesap olustur butonuna basalim
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();

        // 3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
        Actions actions = new Actions(driver);
        WebElement isim = driver.findElement(By.xpath("(//input[@class='inputtext _58mg _5dba _2ph-'])[1]"));
        isim.sendKeys("Idris");
        actions.sendKeys(Keys.TAB).sendKeys("Gemici").
                sendKeys(Keys.TAB).sendKeys("123456789").
                sendKeys(Keys.TAB).sendKeys("sifre1234").
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys("1").sendKeys(Keys.TAB).sendKeys("Oca").sendKeys(Keys.TAB).sendKeys("1986").
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.RIGHT).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();

        // 4- Kaydol tusuna basalim
        WebElement kaydolButton = driver.findElement(By.xpath("//button[@class='_6j mvm _6wk _6wl _58mi _6o _6v']"));
        kaydolButton.click();

    }
}
