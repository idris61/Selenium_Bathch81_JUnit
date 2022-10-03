package A_2_JUnit_Tekrar;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;
import utilities.TestBaseBeforeClassAfterClass;

public class Q38_JsExecutorsScroolIntoViewClassWork extends TestBaseBeforeClassAfterClass {
    @Test
    public void testJsExecuter() {
        //  2 hotelmycamp anasayfasinagidin
        driver.get("https://www.hotelmycamp.com/");

        //  3 2farklitestmethod’uolusturarak actionsclassi ve JsExecutor kullanarak asagidaki odaturlerinden
        //  ustsira ortadaki odayi tiklayin
        WebElement room= driver.findElement(By.xpath("(//*[@class='btn-custom'])[2]"));
        JavascriptExecutor jse= (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);",room);
        jse.executeScript("arguments[0].click();",room);

        //  4istediginiz oda inceleme sayfasi acildigini test edin
        Assert.assertTrue(driver.findElement(By.xpath("(//*[text()='Mrs. Fredericka Kling'])[1]")).isDisplayed());

    }
    @Test
    public void testActions()  {
        driver.get("https://www.hotelmycamp.com/");
        WebElement room= driver.findElement(By.xpath("(//*[@class='btn-custom'])[2]"));
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        room.click();
    }
}
