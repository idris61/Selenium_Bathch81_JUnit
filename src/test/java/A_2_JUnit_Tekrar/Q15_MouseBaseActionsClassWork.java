package A_2_JUnit_Tekrar;

import org.checkerframework.checker.units.qual.A;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class Q15_MouseBaseActionsClassWork extends TestBaseBeforeAfter {
    @Test
    public void MouseActions2Test() throws InterruptedException {
        //1 https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");

        //2 “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        WebElement drogMe = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement dropHere = driver.findElement(By.xpath("//div[@id='droppable']"));
        // Actions actions = new Actions(driver); // Extends yaptığımız TestBase Class'da Actions clasını
                                                  // oluşturduğumuz için direk objeyi burda kullandık
        Thread.sleep(2000);
        actions.dragAndDrop(drogMe,dropHere).perform();

        //3 “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        //Assert.assertTrue(driver.findElement(By.xpath("//p")).getText().contains("Dropped!"));
        Assert.assertEquals(driver.findElement(By.xpath("//p")).getText(),"Dropped!");

    }
}
