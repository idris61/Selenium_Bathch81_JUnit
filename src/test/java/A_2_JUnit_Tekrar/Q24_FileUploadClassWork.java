package A_2_JUnit_Tekrar;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class Q24_FileUploadClassWork extends TestBaseBeforeAfter {
    @Test
    public void test() throws InterruptedException {
        // 2. https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        // 3. chooseFile butonuna basalim
        WebElement dosyaSec = driver.findElement(By.xpath("//input[@id='file-upload']"));
        Thread.sleep(2000);

        // 4. Yuklemek istediginiz dosyayi secelim.
        String dosyaYolu = "C:\\Users\\idris\\Desktop\\Downloads\\QA.jpg";
        dosyaSec.sendKeys(dosyaYolu);

        // 5. Upload butonuna basalim.
        driver.findElement(By.xpath("//input[@id='file-submit']")).click();

        // 6. “File Uploaded!” textinin goruntulendigini test edelim.
        Assert.assertTrue(driver.findElement(By.xpath("//*[h3='File Uploaded!']")).isDisplayed());
    }
}
