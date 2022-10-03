package day12;

import org.checkerframework.checker.units.qual.K;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C01_Action extends TestBaseBeforeAfter {

    @Test
    public void test() throws InterruptedException {

        // Automationexercise.com sitesine gidelim
        driver.get("https://automationexercise.com");

        // product bölümüne girelim
        driver.findElement(By.cssSelector("a[href=\"/products\"]")).click();

        // ilk ürüne tıklayalım
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//i[@class='fa fa-plus-square'])[1]")).click();

    }
}

