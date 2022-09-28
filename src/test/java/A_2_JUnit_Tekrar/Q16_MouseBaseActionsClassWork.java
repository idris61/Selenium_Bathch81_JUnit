package A_2_JUnit_Tekrar;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class Q16_MouseBaseActionsClassWork extends TestBaseBeforeAfter {
    @Test
    public void MouseActions3() {
        // 1 https://www.amazon.com/adresine gidelim
        driver.get("https://www.amazon.com/");

        // 2 Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin
        // mouse’u bu menunun ustune getirelim
        WebElement AccountListsWE  = driver.findElement(By.xpath("(//span[@class='nav-icon nav-arrow'])[1]"));
        actions.moveToElement(AccountListsWE).perform();

        // 3 “Create a list” butonuna basalim
        //driver.findElement(By.xpath("(//span[@class='nav-text'])[1]")).click();
        driver.findElement(By.xpath("//*[text()='Create a List']")).click();

        // 4 Acilan sayfada “Your Lists” yazisi oldugunu test edelim
        Assert.assertEquals(driver.findElement(By.xpath("//div[@role='heading']")).getText(),"Your Lists");

    }
}
