package A_2_JUnit_Tekrar;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBaseBeforeAfter;

import java.io.File;
import java.io.IOException;

public class Q37_GetScreenshotClassWork extends TestBaseBeforeAfter {
    @Test
    public void test() throws IOException {
        // 1- amazon anasayfaya gidin
        driver.get("https://www.amazon.com");

        // 2- amazon anasayfaya gittiginizi test edin ve tum sayfanin goruntusunu kaydedin
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='nav-logo']")).isDisplayed());

        TakesScreenshot ts = (TakesScreenshot) driver;
        File tumSayfaResmi = new File("target/ekranGoruntusu/AllPage"+tarih+".jpeg");
        File geciciDosya = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(geciciDosya,tumSayfaResmi);

        // 3- Nutella icin arama yapin
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella", Keys.ENTER);

        // 4- sonucun Nutella icerdigini test edin ve ilk urunun goruntusunu alin
        String aramaSonucu = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText();
        System.out.println("aramaSonucu = " + aramaSonucu);
        Assert.assertTrue(aramaSonucu.contains("Nutella"));

        WebElement ilkUrunWE = driver.findElement
                (By.xpath("(//div[@class='a-section aok-relative s-image-square-aspect'])[1]"));
        File ilkUrun = ilkUrunWE.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(ilkUrun, new File("target/ekranGoruntusu/AllPage"+tarih+".jpeg"));

    }
}
