package A_2_JUnit_Tekrar;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

import java.util.ArrayList;
import java.util.List;

public class Q29_WindowHandleHomeWork extends TestBaseBeforeAfter {
    @Test
    public void test() throws InterruptedException {
        // 1. "http://webdriveruniversity.com/"adresine gidin
        driver.get("http://webdriveruniversity.com/");

        // 2. "Login Portal" a kadar asagi inin
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);

        // 3. "Login Portal" a tiklayin
        WebElement loginPortalWe = driver.findElement(By.xpath("//h1[text()='LOGIN PORTAL']"));
        loginPortalWe.click();

        // 4. Diger window'a gecin
        List<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(windowHandles.get(1));
        Thread.sleep(2000);

        // 5. "username" ve "password" kutularina deger yazdirin
        Faker faker = new Faker();
        WebElement userName = driver.findElement(By.xpath("//input[@id='text']"));
        userName.sendKeys(faker.name().username());
        Thread.sleep(2000);

        // 6. "login" butonuna basin
        actions.sendKeys(Keys.TAB).sendKeys(faker.internet().password()).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        Thread.sleep(2000);

        // 7. Popup'ta cikan yazinin "validation failed" oldugunu test edin
        String actualPopup = driver.switchTo().alert().getText();
        System.out.println("actualPopup = " + actualPopup);
        Assert.assertEquals(actualPopup, "validation failed");
        Thread.sleep(2000);

        // 8. Ok diyerek Popup'i kapatin
        driver.switchTo().alert().accept();

        // 9. Ilk sayfaya geri donun
        driver.switchTo().window(windowHandles.get(0));

        // 10. Ilk sayfaya donuldugunu testedin
        Assert.assertTrue(loginPortalWe.isDisplayed());
    }
}
