package day12;

import org.checkerframework.checker.units.qual.K;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C01_Action extends TestBaseBeforeAfter {

    // HATA VERDİ TEKRAR BAKILACAK !!!!!!!!!!!!!!!!!!!!!

 // @Test
 // public void test(){
 //     // Automationexercise.com sitesine gidelim
 //     driver.get("https://automationexercise.com");

 //     // product bölümüne girelim
 //     driver.findElement(By.cssSelector("a[href=\"/products\"]")).click();

 //     // ilk ürüne tıklayalım
 //     Actions actions = new Actions(driver);
 //     actions.sendKeys(Keys.PAGE_DOWN).perform();
 //     driver.findElement(By.cssSelector("a[data-product-id=\"1\"]")).click();
 //
 //
 // }
    @Test
    public void test01() {
        //https://www.automationexercise.com/ adresine gidelim
        driver.get("https://www.automationexercise.com/");

        //product bölümüne girelim
        driver.findElement(By.xpath("//*[@class='material-icons card_travel']")).click();
        //ilk ürünü tıklayalım
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        driver.findElement(By.xpath("//*[@class='fa fa-plus-square']")).click();
    }
}

