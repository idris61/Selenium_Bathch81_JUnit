package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import java.util.ArrayList;
import java.util.List;

public class C04_Actions extends TestBaseBeforeAfter {
    @Test
    public void test1() throws InterruptedException {
        // https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");

        // Cizili alan bölümün uzerinde sag click yapalim
        WebElement cizgiliAlan = driver.findElement(By.xpath("//*[@id='hot-spot']"));
        Actions actions = new Actions(driver);
        actions.contextClick(cizgiliAlan).perform();

        // Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.
        String expectedAlertYazisi = "You selected a context menu";
        String actualAlertYazisi = driver.switchTo().alert().getText();
        Assert.assertEquals(expectedAlertYazisi,actualAlertYazisi);
        // Assert.assertEquals("You selected a context menu",driver.switchTo().alert().getText());

        // Tamam diyerek alert’i kapatalim
        Thread.sleep(2000);
        driver.switchTo().alert().accept();

        // Elemental Selenium linkine tiklayalim
        driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();
        List<String> windowlist = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(windowlist.get(1));

        // Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        Assert.assertEquals("Elemental Selenium",driver.findElement(By.xpath("//h1")).getText());

        /*
        // Elemental Selenium linkine tiklayalim

        String ilkSayfaWHDegeri = driver.getWindowHandle(); // ikinci sayfaya geçmeden windowHandle değerini kaydedelim
        driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();  // click tuşuna basınca ikinci sayfa açılıyor

        Set<String> handleSeti = driver.getWindowHandles(); // getWindowHandles bize set döndürdüğü için handles değerlerini sete koyduk
        // Bunu List olarak kaydedebiliriz. ama seleniumun bize döndürdüğü set, seti liste koysanızda
        // setin sıralı getireceğinin garantisi yok,(genelde sıralı getirir fakat sıralı getirmeme ihtimali de var)
        // 1. element 1. sayfanın, 2. element 2. sayfanındır diye kesin konuşamadığımız için bildiğimiz yoldan gidelim
        // ileride göreceğiz. reusable method ile kolaylıkla bu işi halledebileceğiz

        String ikinciSayfaWHDegeri = "";

        for (String handle : handleSeti) {
            if (!each.equals(ilkSayfaWHDegeri)){
                ikinciSayfaWHDegeri = each          // ikinci sayfanın handle değerini elde etmiş olduk
                }
        }

        // Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim

        driver.switchTo().window(ikinciSayfaWHDegeri);      // ikinci sayfaya geçtik
        WebElement yaziElementi = driver.findElement(By.tagName("h1")); // yazı elementini aldık
        String expectedIkinciYazi = "Elemental Selenium";
        String actualIkinciYazi = yaziElementi.getText();
        Assert.assertEquals(expectedIkinciYazi, actualIkinciYazi);
        */

        /*
        click yaptığımızda ikinci sayfaya gittik fakat driver birinci sayfada kaldı.
        click ten sonra yaptığımız işlemleri amacı driver'i ikinci sayfaya taşımak.
         */



    }
}