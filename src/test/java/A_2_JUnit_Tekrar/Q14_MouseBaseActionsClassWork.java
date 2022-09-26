package A_2_JUnit_Tekrar;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Q14_MouseBaseActionsClassWork extends TestBaseBeforeAfter {

    @Test
    public void MouseActionsTest1() {
        // 2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");

        // 3- Cizili alan uzerinde sag click yapalim
        WebElement cizgiliAlan = driver.findElement(By.xpath("//div[@id='hot-spot']"));
        Actions action = new Actions(driver);
        actions.contextClick(cizgiliAlan).perform();

        // 4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.
        String expectedAlertYazisi = "You selected a context menu";
        String actualAlertYazisi = driver.switchTo().alert().getText();
        Assert.assertEquals(actualAlertYazisi,expectedAlertYazisi);

        // 5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();

        // 6- Elemental Selenium linkine tiklayalim
        driver.findElement(By.xpath("//a[@target='_blank']")).click();
        List<String> ListWH = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(ListWH.get(1));

        // 7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        Assert.assertEquals(driver.findElement(By.xpath("//h1")).getText(),"Elemental Selenium");
    }
}
